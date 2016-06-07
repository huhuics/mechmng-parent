/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service;

import org.mechmng.dao.domain.Department;

/**
 * 
 * @author HuHui
 * @version $Id: DepartmentService.java, v 0.1 2016年6月7日 下午8:03:29 HuHui Exp $
 */
public interface DepartmentService {

    /**
     * 根据id查询Department
     * @param id
     * @return
     */
    Department selectByPrimaryKey(Long id);
}
