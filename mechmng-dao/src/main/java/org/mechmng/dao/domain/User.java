package org.mechmng.dao.domain;

public class User extends BaseDomain {

    /** uid */
    private static final long serialVersionUID = -9175975400110980371L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}