/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.util;

import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端发送Http请求工具类
 * @author HuHui
 * @version $Id: HttpUtil.java, v 0.1 2016年6月6日 下午9:49:17 HuHui Exp $
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private HttpUtil() {
    }

    /**
     * 发送不带参数的请求
     * @param url
     * @return
     */
    public static String httpClientPost(String url) {
        String result = "";
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod();
        try {
            client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            LogUtil.error(e, logger, "Http调用发送异常, url={0}", url);
        } finally {
            getMethod.releaseConnection();
        }

        return result;
    }

    /**
     * 发送带参数的http请求
     * @param url
     * @param params 参数集合
     * @return
     */
    public static String httpClientPost(String url, List<NameValuePair> params) {
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod();
        try {
            NameValuePair[] pair = new NameValuePair[params.size()];
            for (int i = 0; i < params.size(); i++) {
                pair[i] = params.get(i);
            }
            postMethod.addParameters(pair);
            client.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        } catch (Exception e) {
            LogUtil.error(e, logger, "Http调用发送异常, url={0}", url);
        } finally {
            postMethod.releaseConnection();
        }

        return result;
    }

}
