/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.mq;

/**
 * 消息接收服务<br>
 * 将会异步监听消息
 * @author HuHui
 * @version $Id: MessageReceiverService.java, v 0.1 2016年5月23日 下午11:02:06 HuHui Exp $
 */
public interface MessageReceiverService {

    void getMessage(Object obj);

}
