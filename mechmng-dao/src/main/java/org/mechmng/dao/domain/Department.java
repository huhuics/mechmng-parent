package org.mechmng.dao.domain;

public class Department extends BaseDomain {

    /** uid */
    private static final long serialVersionUID = 57979080771317777L;

    /**
     *  主键, department.id
     */
    private Long              id;

    /**
     *  部门名称, department.name
     */
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
        this.name = name == null ? null : name.trim();
    }
}