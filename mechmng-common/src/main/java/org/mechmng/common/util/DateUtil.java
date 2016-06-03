/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2016 All Rights Reserved.
 */
package org.mechmng.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日志操作工具类
 * @author huhui
 * @version $Id: DateUtil.java, v 0.1 2016年6月3日 上午10:53:09 huhui Exp $
 */
public final class DateUtil {

    /** 默认样式 */
    private static String DEFAULT_PATTERN = "yyyy-MM-dd";

    /** 时分秒样式 */
    private static String HMS_PATTERN     = "yyyy-MM-dd HH-mm-ss";

    private DateUtil() {
    }

    /**
     * 格式化日期，输出样式为yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * 指定样式格式化日期, 如"yyyy-MM-dd HH-mm-ss"<br>
     * MM大写是为了区分mm(分), HH表示24小时制, hh表示12小时制
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        if (StringUtils.isBlank(pattern)) {
            return format(date);
        }

        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取当前日期, 输出样式为yyyy-MM-dd
     * 
     * @return
     */
    public static String getDate() {
        return format(new Date());
    }

    /**
     * 获取当前日期时间, 样式为"yyyy-MM-dd HH-mm-ss"
     * 
     * @return
     */
    public static String getDateTime() {
        return format(new Date(), HMS_PATTERN);
    }

    /**
     * 获取当前时间, 自定义样式输出
     * 
     * @param pattern
     * @return
     */
    public static String getDateTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 日期计算
     * 
     * @param date   需要参与计算的时间
     * @param field  计算的日历规则, 如Calendar.DAY_OF_MONTH, Calendar.MINUTE, Calendar.SECOND<br>
     * @param amount 正数为加, 负数为减
     * @return
     */
    public static Date addDate(Date date, int field, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

}
