/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.mvc.integration.UserFacadeClient;

/**
 * 
 * @author HuHui
 * @version $Id: UserFacadeClientTest.java, v 0.1 2016年5月22日 上午11:57:55 HuHui Exp $
 */
public class UserFacadeClientTest extends BaseTest {

    @Resource
    private UserFacadeClient userFacadeClient;

    @Test
    public void testSelectUserById() {
        Assert.assertNotNull(userFacadeClient);
        Result<UserDTO> userRet = userFacadeClient.selectUserById(1L);
        Assert.assertNotNull(userRet);
        Assert.assertTrue(userRet.isSuccess());
        Assert.assertNotNull(userRet.getResultObj());
        Assert.assertTrue(userRet.getResultObj().getId() == 1L);
    }
}
