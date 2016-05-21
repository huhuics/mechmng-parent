/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mechmng.common.facade.result.PageList;
import org.mechmng.common.util.AssertUtil;
import org.mechmng.dao.UserDAO;
import org.mechmng.dao.domain.User;
import org.mechmng.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * UserService的实现类
 * @author HuHui
 * @version $Id: UserServiceImpl.java, v 0.1 2016年5月21日 下午8:37:43 HuHui Exp $
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserDAO                     userDao;

    @Override
    public User selectByPrimaryKey(Long id) {
        logger.info("收到查询条件:{}", id);
        AssertUtil.assertNotNull(id, "查询参数id为空");
        User user = userDao.selectByPrimaryKey(id);
        logger.info("查询结果:{}", user);
        return user;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        logger.info("收到删除条件:{}", id);
        AssertUtil.assertNotNull(id, "查询参数id为空");
        int ret = userDao.deleteByPrimaryKey(id);
        return ret > 0;
    }

    @Override
    public PageList<User> getUsers(int pageNum, int pageSize) {
        logger.info("收到查询参数, pageNum={}, pageSize={}", pageNum, pageSize);

        AssertUtil.assertNotNull(pageNum, "查询参数pageNum为空");
        AssertUtil.assertNotNull(pageSize, "查询参数pageSize为空");

        PageList<User> pageList = new PageList<User>();

        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.queryAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);

        pageList.setData(users);
        pageList.setPageInfo(pageInfo);

        return pageList;
    }
}
