/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mechmng.common.facade.result.PageList;
import org.mechmng.dao.domain.User;
import org.mechmng.service.UserService;

/**
 * 测试UserService
 * @author HuHui
 * @version $Id: UserServiceTest.java, v 0.1 2016年5月21日 下午9:06:42 HuHui Exp $
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testSelectByPrimaryKey() {
        Assert.assertNotNull(userService);
        User user = userService.selectByPrimaryKey(1L);
        Assert.assertNotNull(user);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        Assert.assertNotNull(userService);
        boolean ret = userService.deleteByPrimaryKey(59L);
        Assert.assertTrue(ret);
    }

    /**
     * 测试分页查询User
     */
    @Test
    public void testQueryUsersByPage() {
        int pageNum = 1;
        int pageSize = 10;
        PageList<User> users = userService.getUsers(pageNum, pageSize);
        Assert.assertNotNull(users);
        Assert.assertNotNull(users.getData());
        Assert.assertNotNull(users.getPageInfo());
        Assert.assertEquals(users.getData().size(), 10);
        Assert.assertEquals(users.getPageInfo().getPageNum(), pageNum);
        Assert.assertEquals(users.getPageInfo().getPageSize(), pageSize);
    }
}
