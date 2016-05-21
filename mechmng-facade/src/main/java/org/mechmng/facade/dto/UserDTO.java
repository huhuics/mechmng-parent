/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.dto;

/**
 * 
 * @author HuHui
 * @version $Id: UserDTO.java, v 0.1 2016年5月22日 上午12:24:53 HuHui Exp $
 */
public class UserDTO extends BaseDTO {

    /** uid */
    private static final long serialVersionUID = 9215334603899662544L;

    /**
     *  主键, user.id
     */
    private Long              id;

    /**
     *  姓名, user.name
     */
    private String            name;

    /**
     *  密码, user.password
     */
    private String            password;

    /**
     *  年龄, user.age
     */
    private Integer           age;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
