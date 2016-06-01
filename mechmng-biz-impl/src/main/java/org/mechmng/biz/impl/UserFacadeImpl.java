package org.mechmng.biz.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.mechmng.biz.impl.convertor.UserConvertor;
import org.mechmng.common.facade.result.PageList;
import org.mechmng.common.facade.result.Result;
import org.mechmng.common.util.AssertUtil;
import org.mechmng.common.util.LogUtil;
import org.mechmng.common.util.Exception.MechException;
import org.mechmng.dao.domain.User;
import org.mechmng.facade.api.UserFacade;
import org.mechmng.facade.dto.PageDTO;
import org.mechmng.facade.dto.UserDTO;
import org.mechmng.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * UserFacade的实现类
 * @author HuHui
 * @version $Id: UserFacadeImpl.java, v 0.1 2016年5月22日 上午1:03:00 HuHui Exp $
 */
@Service
@SuppressWarnings("unchecked")
@WebService(endpointInterface = "org.mechmng.facade.api.UserFacade")
public class UserFacadeImpl implements UserFacade {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);

    @Resource
    private UserService         userService;

    @Override
    public Result<UserDTO> selectByPrimaryKey(Long id) {
        LogUtil.info(logger, "收到查询参数:{0}", id);
        Result<UserDTO> result = new Result<UserDTO>();
        try {
            AssertUtil.assertNotNull(id, "查询参数id为空");
            User user = userService.selectByPrimaryKey(id);
            UserDTO userDTO = UserConvertor.convert2UserDTO(user);
            result.setResultObj(userDTO);
            result.setSuccess(true);
        } catch (Exception e) {
            LogUtil.error(e, logger, "查询用户失败, id={0}", id);
            throw new MechException("查询用户失败", e);
        }

        return result;
    }

    @Override
    public Result<PageDTO<UserDTO>> getUsers(int pageNum, int pageSize) {
        LogUtil.info(logger, "收到查询参数, pageNum={0}, pageSize={1}", pageNum, pageSize);
        Result<PageDTO<UserDTO>> result = new Result<PageDTO<UserDTO>>();
        try {
            AssertUtil.assertNotNull(pageNum, "查询参数pageNum为空");
            AssertUtil.assertNotNull(pageSize, "查询参数pageSize为空");

            PageDTO<UserDTO> userDTOs = new PageDTO<UserDTO>();

            PageList<User> users = userService.getUsers(pageNum, pageSize);

            userDTOs.setPageInfo(users.getPageInfo());
            userDTOs.setData(UserConvertor.convert2UserDTOs(users.getData()));

            result.setResultObj(userDTOs);
            result.setSuccess(true);

        } catch (Exception e) {
            LogUtil.error(e, logger, "查询用户失败, pageNum={0}, pageSize={1}", pageNum, pageSize);
            throw new MechException("查询用户失败", e);
        }

        return result;
    }

}
