/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.test.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mechmng.common.ftp.FtpClient;

/**
 * 测试FtpClient
 * @author HuHui
 * @version $Id: FtpClientTest.java, v 0.1 2016年6月11日 下午5:12:05 HuHui Exp $
 */
public class FtpClientTest {

    private FtpClient ftpClient = null;

    @Before
    public void init() {
        ftpClient = new FtpClient("127.0.0.1", 21, "test", "test");
    }

    @Test
    public void testUpload() {
        boolean ret = ftpClient.uploadFile("f:\\ftp", "d:\\ftp");
        Assert.assertTrue(ret == true);

        ftpClient.close();
    }

}
