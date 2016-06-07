/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.biz.impl;

import javax.annotation.Resource;

import org.mechmng.biz.impl.convertor.DepartmentConvertor;
import org.mechmng.common.facade.result.Result;
import org.mechmng.common.util.AssertUtil;
import org.mechmng.common.util.LogUtil;
import org.mechmng.common.util.Exception.MechException;
import org.mechmng.dao.domain.Department;
import org.mechmng.facade.api.DepartmentFacade;
import org.mechmng.facade.dto.DepartmentDTO;
import org.mechmng.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author HuHui
 * @version $Id: DepartmentFacadeImpl.java, v 0.1 2016年6月7日 下午8:14:36 HuHui Exp $
 */
@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentFacadeImpl.class);

    @Resource
    private DepartmentService   departmentService;

    @Override
    public Result<DepartmentDTO> getById(Long id) {
        LogUtil.info(logger, "收到查询参数,id={0}", id);

        Result<DepartmentDTO> result = new Result<DepartmentDTO>();
        try {
            AssertUtil.assertNotNull(id, "查询参数id为空");
            Department department = departmentService.selectByPrimaryKey(id);
            DepartmentDTO departmentDTO = DepartmentConvertor.convert2DepartmentDTO(department);
            result.setResultObj(departmentDTO);
            result.setSuccess(true);
        } catch (Exception e) {
            LogUtil.error(e, logger, "查询Department异常,id={0}", id);
            throw new MechException("查询Department异常");
        }
        return result;
    }

}
