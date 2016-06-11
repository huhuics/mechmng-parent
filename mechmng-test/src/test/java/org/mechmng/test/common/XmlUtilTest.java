/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.test.common;

import java.io.File;
import java.util.Map;

import org.junit.Test;
import org.mechmng.common.util.FileUtil;
import org.mechmng.common.util.LogUtil;
import org.mechmng.common.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试XmlUtil
 * @author HuHui
 * @version $Id: XmlUtil.java, v 0.1 2016年6月11日 下午12:50:54 HuHui Exp $
 */
public class XmlUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(XmlUtilTest.class);

    @Test
    public void testPrseXml2Map() {
        String pStrXml = FileUtil.readFileToString(new File("F:\\web.xml"));
        Map map = XmlUtil.parseXml2Map(pStrXml);
        LogUtil.info(logger, "{0}", map);
        String xml = XmlUtil.parseMap2Xml(map, "web");
        LogUtil.info(logger, "{0}", xml);
    }

}
