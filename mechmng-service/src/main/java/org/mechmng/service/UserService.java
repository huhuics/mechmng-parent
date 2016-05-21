/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service;

import org.mechmng.dao.domain.User;

/**
 * User服务型相关
 * @author HuHui
 * @version $Id: UserService.java, v 0.1 2016年5月21日 下午8:31:39 HuHui Exp $
 */
public interface UserService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectByPrimaryKey(Long id);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Long id);

}
