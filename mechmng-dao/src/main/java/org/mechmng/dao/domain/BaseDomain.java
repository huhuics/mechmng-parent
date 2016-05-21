/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.dao.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Domain的基础类
 * @author HuHui
 * @version $Id: BaseDomain.java, v 0.1 2016年5月21日 下午8:17:11 HuHui Exp $
 */
public class BaseDomain implements Serializable {

    /** uid */
    private static final long serialVersionUID = 1680715921816738011L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
