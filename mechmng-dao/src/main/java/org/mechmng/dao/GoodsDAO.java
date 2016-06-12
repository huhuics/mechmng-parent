package org.mechmng.dao;

import java.util.List;

import org.mechmng.dao.domain.Goods;

public interface GoodsDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryAll();
}