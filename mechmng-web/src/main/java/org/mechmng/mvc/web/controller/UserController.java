/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.web.controller;

import javax.annotation.Resource;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.mvc.integration.UserFacadeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author HuHui
 * @version $Id: HelloController.java, v 0.1 2016年5月22日 上午11:34:48 HuHui Exp $
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserFacadeClient    userFacadeClient;

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String toShowUser(WebRequest request, ModelMap map) {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Result<UserDTO> userRet = userFacadeClient.selectUserById(id);

            map.put("user", userRet.getResultObj());
        } catch (Exception e) {
            logger.error("查询用户信息异常", e);
        }
        return "showUser";
    }
}
