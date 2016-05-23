/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.mq;

import org.mechmng.dao.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author HuHui
 * @version $Id: MessageReceiverServiceImpl.java, v 0.1 2016年5月23日 下午11:02:25 HuHui Exp $
 */
public class MessageReceiverServiceImpl implements MessageReceiverService {

    private static final Logger logger = LoggerFactory.getLogger(MessageReceiverServiceImpl.class);

    @Override
    public void getMessage(Object obj) {
        logger.info("mechmng-biz-impl接收到消息");
        if (obj instanceof User) {
            User user = (User) obj;
            logger.info("消息体为user:{}", user);
        }
    }

}
