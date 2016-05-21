/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.dto;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 分页数据和分页信息
 * @author HuHui
 * @version $Id: PageDTO.java, v 0.1 2016年5月21日 下午8:46:52 HuHui Exp $
 */
public class PageDTO<T> extends BaseDTO {

    /** uid */
    private static final long serialVersionUID = 712175161724105717L;

    /** 分页信息 */
    private PageInfo<T>       pageInfo;

    /** 分页对象集合 */
    private List<T>           data;

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
