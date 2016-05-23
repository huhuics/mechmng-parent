/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.biz.impl.mq;

/**
 * 消息接收服务<br>
 * 将会异步监听消息
 * @author HuHui
 * @version $Id: MessageReceiverService.java, v 0.1 2016年5月22日 下午11:14:15 HuHui Exp $
 */
public interface MessageReceiverServiceClient {

    void getMessage(Object obj);

}
