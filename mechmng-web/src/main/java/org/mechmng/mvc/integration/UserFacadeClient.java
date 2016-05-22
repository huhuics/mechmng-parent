/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.integration;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.PageDTO;
import org.mechmng.facade.dto.UserDTO;

/**
 * UserFacade 客户端
 * @author HuHui
 * @version $Id: UserFacadeClient.java, v 0.1 2016年5月22日 上午11:43:19 HuHui Exp $
 */
public interface UserFacadeClient {

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    Result<UserDTO> selectUserById(Long id);

    /**
     * 分页查询用户信息
     * @param pageNum 当前页数
     * @param pageSize 每页显示数量
     * @return
     */
    Result<PageDTO<UserDTO>> getUsers(int pageNum, int pageSize);

}
