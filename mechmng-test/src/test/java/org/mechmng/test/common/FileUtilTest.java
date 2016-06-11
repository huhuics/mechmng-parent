/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.test.common;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.mechmng.common.util.FileUtil;
import org.mechmng.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author HuHui
 * @version $Id: FileUtilTest.java, v 0.1 2016年6月11日 下午1:36:57 HuHui Exp $
 */
public class FileUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(FileUtilTest.class);

    @Test
    public void testReadFileToString() {
        File file = new File("F:\\test.txt");
        String fileStr = FileUtil.readFileToString(file);
        LogUtil.info(logger, "{0}", fileStr);
    }

    @Test
    public void testReadLines() {
        File file = new File("F:\\test.txt");
        List<String> lines = FileUtil.readLines(file);
        LogUtil.info(logger, "{0}", lines);
    }

}
