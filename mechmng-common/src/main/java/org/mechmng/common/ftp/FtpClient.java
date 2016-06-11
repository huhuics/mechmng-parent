/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.mechmng.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP上传下载
 * @author HuHui
 * @version $Id: FtpClient.java, v 0.1 2016年6月11日 下午3:37:56 HuHui Exp $
 */
public class FtpClient {

    private Logger              logger    = LoggerFactory.getLogger(FtpClient.class);

    /** 对象锁 */
    private static final byte[] LOCK      = { 0 };

    private static FTPClient    ftpClient = null;

    public FtpClient(String host, int port, String username, String password) {
        init(host, port, username, password);
    }

    /**
     * 初始化FTP连接
     * @param host      ftp服务器地址
     * @param port      ftp服务器端口
     * @param username  ftp用户名
     * @param password  ftp密码
     */
    private void init(String host, int port, String username, String password) throws RuntimeException {
        synchronized (LOCK) {
            if (ftpClient == null) {
                ftpClient = new FTPClient();
                ftpClient.setControlEncoding(StandardCharsets.UTF_8.name());
            }
            try {
                //连接FTP服务器
                ftpClient.connect(host, port);
            } catch (Exception e) {
                LogUtil.error(e, logger, "FTP[{0}:{1}]连接失败!", host, port);
                throw new RuntimeException("FTP连接失败!", e);
            }

            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                try {
                    ftpClient.login(username, password);
                } catch (Exception e) {
                    LogUtil.error(e, logger, "FTP用户{0}登录失败!", username);
                    throw new RuntimeException("FTP用户登录失败", e);
                }
            } else {
                throw new RuntimeException("FTP连接失败!");
            }

            LogUtil.info(logger, "用户{0}登录FTP服务器{1}成功!", username, host);

            try {
                //设置为被动模式
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileTransferMode(FTPClient.STREAM_TRANSFER_MODE);
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            } catch (Exception e) {
                LogUtil.error(e, logger, "FTP初始化出错!");
                throw new RuntimeException("FTP初始化出错!", e);
            }

        }
    }

    /**
     * 关闭ftp客户端
     * @throws RuntimeException
     */
    public void close() throws RuntimeException {
        synchronized (LOCK) {
            try {
                ftpClient.logout();
            } catch (Exception e) {
                ftpClient = null;
                LogUtil.error(e, logger, "FTP退出异常");
                throw new RuntimeException("FTP退出异常", e);
            }
            LogUtil.info(logger, "用户退出登录");
        }
    }

    /**
     * 上传文件<br>
     * 如果参数localFile是目录,则上传该目录下所有文件;如果localFIle是文件,则上传该文件
     * @param localPath
     * @param remotePath
     * @return
     * @throws RuntimeException
     */
    public boolean uploadFile(String localPath, String remotePath) throws RuntimeException {
        synchronized (LOCK) {
            File file = new File(localPath);
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (!uploadFile(files[i], remotePath)) {
                    return false;
                }
            }
            return files.length > 0;
        }
    }

    /**
     * 上传文件<br>
     * 如果参数localFile是目录,则上传该目录下所有文件;如果localFIle是文件,则上传该文件
     * @param localFile    本地目录/文件
     * @param remotePath   上传目录
     * @return
     * @throws RuntimeException
     */
    public boolean uploadFile(File localFile, String remotePath) throws RuntimeException {
        synchronized (LOCK) {
            FileInputStream fis = null;
            try {
                if (localFile.isDirectory()) {
                    boolean flag = false;
                    ftpClient.makeDirectory(localFile.getName());
                    ftpClient.changeWorkingDirectory(localFile.getName());
                    LogUtil.info(logger, "{0}目录", localFile.getAbsolutePath());

                    File[] files = localFile.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        if (uploadFile(files[i], remotePath + File.separator + localFile.getName())) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }

                    ftpClient.changeToParentDirectory();

                    return flag;
                } else {
                    fis = new FileInputStream(localFile);
                    ftpClient.storeFile(localFile.getName(), fis);
                    LogUtil.info(logger, "{0}上传成功!", localFile.getAbsolutePath());
                }
                return true;
            } catch (IOException e) {
                LogUtil.error(e, logger, "FTP上传失败{0}", localFile.getAbsolutePath());
                throw new RuntimeException("FTP上传失败", e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    public boolean downloadFile(String remotePath, String localPath) throws RuntimeException {
        synchronized (LOCK) {
            try {
                if (ftpClient.changeWorkingDirectory(remotePath)) {//转移到FTP服务器目录
                    FTPFile[] files = ftpClient.listFiles();
                    if (files.length != 0) {
                        File localDir = new File(localPath);
                        if (!localDir.exists()) {
                            localDir.mkdir();
                        }
                    }
                    for (FTPFile ff : files) {
                        if (!downloadFile(ff, localPath)) {
                            return false;
                        }
                    }
                    return files.length > 0;
                }
            } catch (Exception e) {
                LogUtil.error(e, logger, "FTP下载{0}出错!", localPath);
                throw new RuntimeException("FTP下载出错", e);
            }
            return false;
        }
    }

    /**
     * 下载文件<br>
     * 如果参数ftpFile是目录,则下载该目录下所有文件;如果ftpFile是文件,则下载该文件
     * @param ftpFile    下载文件/目录
     * @param localPath  本地目录
     * @return
     */
    public boolean downloadFile(FTPFile ftpFile, String localPath) {
        String localFilePath = localPath + File.separator + ftpFile.getName();
        if (ftpFile.isDirectory()) { // deal directory
            File file = new File(localFilePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                if (ftpClient.changeWorkingDirectory(ftpFile.getName())) {
                    LogUtil.info(logger, "{0}目录", file.getAbsolutePath());
                    FTPFile[] files = ftpClient.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        downloadFile(files[i], localFilePath);
                    }

                    ftpClient.changeToParentDirectory();

                    return true;
                }
            } catch (Exception e) {
                LogUtil.error(e, logger, "FTP下载{0}出错!", localFilePath);
                throw new RuntimeException("FTP下载出错", e);
            }
        } else { // deal file
            if (ftpFile.getName().indexOf("?") == -1) {
                OutputStream outputStream = null;
                try {
                    File localFile = new File(localFilePath);
                    if (!localFile.getParentFile().exists()) {
                        localFile.getParentFile().mkdirs();
                    }
                    outputStream = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(ftpFile.getName(), outputStream);
                    outputStream.flush();

                    LogUtil.info(logger, "{0}下载成功!", localFile.getAbsolutePath());

                    return true;
                } catch (Exception e) {
                    LogUtil.error(e, logger, "FTP下载{0}出错!", localFilePath);
                    throw new RuntimeException("FTP下载出错", e);
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                            outputStream = null;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }

        return false;
    }

}
