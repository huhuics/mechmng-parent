/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.web.controller;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.mvc.integration.UserFacadeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
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

    @Resource
    private JmsTemplate         jmsTemplate;

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

    @RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
    public String toSendMsg(WebRequest request, ModelMap map) {
        try {
            Result<UserDTO> userRet = userFacadeClient.selectUserById(1L);
            final UserDTO userDTO = userRet.getResultObj();
            map.put("user", userDTO);

            //向mechmng-biz-impl发送消息
            logger.info("开始发送消息,内容:{}", userDTO);
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(userDTO);
                }
            });
        } catch (Exception e) {
            logger.error("查询用户信息异常", e);
        }
        logger.info("消息发送完毕");
        return "sendMsg";
    }
}
