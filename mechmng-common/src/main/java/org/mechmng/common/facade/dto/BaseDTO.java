/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.facade.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO基础类
 * @author HuHui
 * @version $Id: BaseDTO.java, v 0.1 2016年5月21日 下午8:44:54 HuHui Exp $
 */
public class BaseDTO implements Serializable {

    /** uid */
    private static final long serialVersionUID = -6387732690500793504L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
