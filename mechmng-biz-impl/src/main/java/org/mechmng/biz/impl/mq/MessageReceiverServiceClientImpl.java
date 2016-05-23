/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.biz.impl.mq;

import javax.annotation.Resource;

import org.mechmng.biz.impl.convertor.UserConvertor;
import org.mechmng.dao.domain.User;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.service.mq.MessageReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author HuHui
 * @version $Id: MessageReceiverServiceImpl.java, v 0.1 2016年5月22日 下午11:19:18 HuHui Exp $
 */
@Service
public class MessageReceiverServiceClientImpl implements MessageReceiverServiceClient {

    private static final Logger    logger = LoggerFactory.getLogger(MessageReceiverServiceClientImpl.class);

    @Resource
    private MessageReceiverService messageReceiverService;

    @Override
    public void getMessage(Object obj) {
        logger.info("mechmng-biz-impl接收到消息");
        if (obj instanceof UserDTO) {
            UserDTO userDTO = (UserDTO) obj;
            logger.info("消息体为userDTO:{}", userDTO);
            User user = UserConvertor.convert2User(userDTO);
            messageReceiverService.getMessage(user);
        }
    }
}
