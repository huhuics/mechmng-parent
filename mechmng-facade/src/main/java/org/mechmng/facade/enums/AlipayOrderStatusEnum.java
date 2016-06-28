/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 支付宝订单状态枚举
 * @author HuHui
 * @version $Id: AlipayOrderStatus.java, v 0.1 2016年6月28日 下午10:18:27 HuHui Exp $
 */
public enum AlipayOrderStatusEnum {

    INIT("INIT", "已创建"),

    PAID("PAID", "已支付"),

    CLOSE("CLOSE", "已关闭"),

    CANCEL("CANCEL", "已取消"),

    REFUND("REFUND", "已退款")

    ;

    /** 枚举代码 */
    private String code;

    /** 枚举值 */
    private String desc;

    private AlipayOrderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据代码获取枚举，如果code对应的枚举不存在，则返回null
     * @param code 枚举代码
     * @return     对应的枚举对象
     */
    public static AlipayOrderStatusEnum getByCode(String code) {
        for (AlipayOrderStatusEnum eachValue : AlipayOrderStatusEnum.values()) {
            if (StringUtils.equals(code, eachValue.getCode())) {
                return eachValue;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
