/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.biz.impl.mq;

import org.mechmng.facade.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author HuHui
 * @version $Id: MessageReceiverServiceImpl.java, v 0.1 2016年5月22日 下午11:19:18 HuHui Exp $
 */
public class MessageReceiverServiceImpl implements MessageReceiverService {

    private static final Logger logger = LoggerFactory.getLogger(MessageReceiverServiceImpl.class);

    @Override
    public void getMessage(Object obj) {
        logger.info("mechmng-biz-impl接收到消息");
        if (obj instanceof UserDTO) {
            UserDTO userDTO = (UserDTO) obj;
            logger.info("消息体为userDTO:{}", userDTO);
        }
    }

}
