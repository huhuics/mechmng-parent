/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.biz.impl.convertor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.mechmng.dao.domain.User;
import org.mechmng.facade.dto.UserDTO;

/**
 * 提供静态方法，User领域对象转换工具
 * @author HuHui
 * @version $Id: UserConvertor.java, v 0.1 2016年5月22日 上午1:16:00 HuHui Exp $
 */
public class UserConvertor {

    public static User convert2User(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());

        return user;
    }

    /**
     * 将User转换为UserDTO
     * @param user
     * @return
     */
    public static UserDTO convert2UserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setAge(user.getAge());

        return userDTO;
    }

    public static List<UserDTO> convert2UserDTOs(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }

        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User user : users) {
            UserDTO userDTO = convert2UserDTO(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

}
