/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.api;

import javax.jws.WebService;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.PageDTO;
import org.mechmng.facade.dto.UserDTO;

/**
 * 
 * @author HuHui
 * @version $Id: UserFacade.java, v 0.1 2016年5月21日 下午11:30:02 HuHui Exp $
 */
@WebService
public interface UserFacade {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Result<UserDTO> selectByPrimaryKey(Long id);

    /**
     * 查询用户，带分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result<PageDTO<UserDTO>> getUsers(int pageNum, int pageSize);

}
