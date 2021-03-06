package org.mechmng.dao;

import java.util.List;

import org.mechmng.dao.domain.User;

public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryAll();
}