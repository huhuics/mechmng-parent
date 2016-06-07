/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.dto;

/**
 * 
 * @author HuHui
 * @version $Id: DepartmentDTO.java, v 0.1 2016年6月7日 下午8:13:01 HuHui Exp $
 */
public class DepartmentDTO extends BaseDTO {

    /**  */
    private static final long serialVersionUID = -7900749825231940640L;

    private Long              id;

    private String            name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
