/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.test.common;

import org.junit.Test;
import org.mechmng.common.util.LogUtil;
import org.mechmng.common.util.RMBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author HuHui
 * @version $Id: RMBUtil.java, v 0.1 2016年6月22日 下午11:05:52 HuHui Exp $
 */
public class RMBUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(RMBUtil.class);

    @Test
    public void test() {
        double money = 3.125;
        String ret = RMBUtil.numToRMBStr(money);
        LogUtil.info(logger, "money={0}", ret);
    }

}
