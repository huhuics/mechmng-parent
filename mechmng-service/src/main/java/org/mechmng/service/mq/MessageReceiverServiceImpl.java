/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.mq;

import org.mechmng.common.util.LogUtil;
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
        LogUtil.info(logger, "mechmng-service接收到消息,消息体obj={0}", obj);
    }

}
