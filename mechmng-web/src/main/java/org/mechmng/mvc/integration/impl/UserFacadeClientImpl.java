/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.integration.impl;

import javax.annotation.Resource;

import org.mechmng.common.facade.result.Result;
import org.mechmng.common.util.LogUtil;
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
        LogUtil.info(logger, "收到查询用户参数,id={0}", id);
        Result<UserDTO> result = new Result<UserDTO>();
        try {
            result = userFacade.selectByPrimaryKey(id);
        } catch (Exception e) {
            LogUtil.error(e, logger, "用户查询异常,id={0}", id);
        }
        return result;
    }

    /** 
     * @see org.mechmng.mvc.integration.UserFacadeClient#getUsers(int, int)
     */
    @Override
    public Result<PageDTO<UserDTO>> getUsers(int pageNum, int pageSize) {
        LogUtil.info(logger, "收到查询参数, pageNum={0}, pageSize={1}", pageNum, pageSize);
        Result<PageDTO<UserDTO>> result = new Result<PageDTO<UserDTO>>();
        try {
            result = userFacade.getUsers(pageNum, pageSize);
        } catch (Exception e) {
            LogUtil.error(e, logger, "查询用户失败, pageNum={0}, pageSize={1}", pageNum, pageSize);
        }
        return result;
    }

}
