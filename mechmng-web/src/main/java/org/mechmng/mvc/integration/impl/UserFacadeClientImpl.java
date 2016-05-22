/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.integration.impl;

import javax.annotation.Resource;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.api.UserFacade;
import org.mechmng.facade.dto.PageDTO;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.mvc.integration.UserFacadeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * UserFacadeClient实现类
 * @author HuHui
 * @version $Id: UserFacadeClientImpl.java, v 0.1 2016年5月22日 上午11:47:27 HuHui Exp $
 */
@Service
public class UserFacadeClientImpl implements UserFacadeClient {

    private static final Logger logger = LoggerFactory.getLogger(UserFacadeClientImpl.class);

    @Resource
    private UserFacade          userFacade;

    /** 
     * @see org.mechmng.mvc.integration.UserFacadeClient#selectUserById(java.lang.Long)
     */
    @Override
    public Result<UserDTO> selectUserById(Long id) {
        logger.info("收到查询用户参数,id={}", id);
        Result<UserDTO> result = new Result<UserDTO>();
        try {
            result = userFacade.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("用户查询异常,id={}", id, e);
            //TODO
            //抛出自定义异常
        }
        return result;
    }

    /** 
     * @see org.mechmng.mvc.integration.UserFacadeClient#getUsers(int, int)
     */
    @Override
    public Result<PageDTO<UserDTO>> getUsers(int pageNum, int pageSize) {
        logger.info("收到查询参数, pageNum={}, pageSize={}", pageNum, pageSize);
        Result<PageDTO<UserDTO>> result = new Result<PageDTO<UserDTO>>();
        try {
            result = userFacade.getUsers(pageNum, pageSize);
        } catch (Exception e) {
            logger.error("查询用户失败, pageNum={1}, pageSize={2}", pageNum, pageSize, e);
        }
        return result;
    }

}
