/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * XML处理工具类
 * @author HuHui
 * @version $Id: XmlUtil.java, v 0.1 2016年6月6日 下午10:44:10 HuHui Exp $
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class XmlUtil {

    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    private XmlUtil() {
    }

    /**
     * 解析XML并将其节点元素存入Map中返回<br>
     * 注意:无法递归解析xml,即有子节点的xml将无法解析
     * @param pStrXml 待解析的XML字符串
     * @return
     */
    public static Map parseXml2Map(String pStrXml) {
        Map map = new HashMap();
        String strTitle = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        Document document = null;
        try {
            if (pStrXml.indexOf("<?xml") < 0) {
                pStrXml = strTitle + pStrXml;
            }
            document = DocumentHelper.parseText(pStrXml);
        } catch (DocumentException e) {
            LogUtil.error(e, logger, "XML格式字符串转换为XML DOM对象时发生异常");
        }

        //获取根节点
        Element node = document.getRootElement();

        //遍历节点属性值，存入Map中
        for (Iterator it = node.elementIterator(); it.hasNext();) {
            Element element = (Element) it.next();
            map.put(element.getName().toLowerCase(), element.getData());
        }

        return map;
    }

    /**
     * 将map转换为符合XML标准规范格式的字符串(基于节点值形式)
     * @param map            传入的map对象,key和value都是String类型
     * @param pRootNodeName  根节点名
     * @return               返回XML格式字符串
     */
    public static String parseMap2Xml(Map<String, String> map, String pRootNodeName) {
        Document document = DocumentHelper.createDocument();
        //增加一个根元素节点
        document.addElement(pRootNodeName);
        Element root = document.getRootElement();
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            String value = map.get(key);
            Element leaf = root.addElement(key);
            leaf.setText(value);
        }
        String outXml = document.asXML();
        return outXml;
    }
}
