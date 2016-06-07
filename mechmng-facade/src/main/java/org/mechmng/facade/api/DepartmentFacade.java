/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.facade.api;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.DepartmentDTO;

/**
 * 
 * @author HuHui
 * @version $Id: DepartmentFacade.java, v 0.1 2016年6月7日 下午8:10:48 HuHui Exp $
 */
public interface DepartmentFacade {

    /**
     * 根据id查询Department对象
     * @param id
     * @return
     */
    Result<DepartmentDTO> getById(Long id);
}
