/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.integration;

import org.mechmng.common.facade.result.Result;
import org.mechmng.facade.dto.DepartmentDTO;

/**
 * 
 * @author HuHui
 * @version $Id: DepartmentFacadeClient.java, v 0.1 2016年6月7日 下午8:46:51 HuHui Exp $
 */
public interface DepartmentFacadeClient {

    Result<DepartmentDTO> getById(Long id);

}
