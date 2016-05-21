/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.facade.result;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 分页结果，包含分页数据和分页信息
 * @author HuHui
 * @version $Id: PageList.java, v 0.1 2016年5月22日 上午12:52:45 HuHui Exp $
 */
@SuppressWarnings("rawtypes")
public class PageList<T> {

    /** 分页信息 */

    private PageInfo pageInfo;

    /** 分页对象集合 */
    private List<T>  data;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
