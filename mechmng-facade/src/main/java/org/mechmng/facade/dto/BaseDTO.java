/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO的基础类
 * @author HuHui
 * @version $Id: BaseDTO.java, v 0.1 2016年5月22日 上午12:25:04 HuHui Exp $
 */
public class BaseDTO implements Serializable {

    /** uid */
    private static final long serialVersionUID = -4525556841887236914L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
