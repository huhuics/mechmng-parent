/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作的工具类
 * @author HuHui
 * @version $Id: FileUtil.java, v 0.1 2016年6月11日 下午1:03:51 HuHui Exp $
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {
    }

    /**
     * 使用UTF-8编码格式读取文件内容以String对象返回<br>
     * 每次调用结束IO流已关闭
     * @param file
     * @return
     */
    public static String readFileToString(File file) {
        String fileStr = null;
        try {
            fileStr = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LogUtil.error(e, logger, "读取文件失败");
        }
        return fileStr;
    }

    /**
     * 使用UTF-8编码格式读取文件内容，
     * @param file
     * @return 集合中的每一个元素为文件的每一行内容
     */
    public static List<String> readLines(File file) {
        List<String> strLines = null;
        try {
            strLines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LogUtil.error(e, logger, "读取文件失败");
        }
        return strLines;
    }

}
