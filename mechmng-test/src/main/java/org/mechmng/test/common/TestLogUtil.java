/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.test.common;

import org.junit.Test;
import org.mechmng.common.util.LogUtil;
import org.mechmng.common.util.Exception.MechException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试LogUtil类
 * @author HuHui
 * @version $Id: TestLogUtil.java, v 0.1 2016年6月1日 下午9:26:19 HuHui Exp $
 */
public class TestLogUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestLogUtil.class);

    @Test
    public void testErrorLog() {
        String a = "string";
        int b = 123;
        LogUtil.error(logger, "a是一个参数:{0}", a);
        LogUtil.error(new MechException("参数异常"), logger, "a是一个字符串参数:{0}; b是一个整数:{1}", a, b);
    }

    @Test
    public void testInfoLog() {
        String a = "string";
        int b = 123;
        LogUtil.info(logger, "a是一个参数:{0}", a);
        LogUtil.info(logger, "a是一个字符串参数:{0}; b是一个整数:{1}", a, b);
    }

}
