/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.impl;

import javax.annotation.Resource;

import org.mechmng.common.util.AssertUtil;
import org.mechmng.common.util.LogUtil;
import org.mechmng.dao.GoodsDAO;
import org.mechmng.dao.domain.Goods;
import org.mechmng.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author HuHui
 * @version $Id: GoodsServiceImpl.java, v 0.1 2016年6月12日 下午8:51:29 HuHui Exp $
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private Logger   logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Resource
    private GoodsDAO goodsDAO;

    @Override
    public Goods selectByPrimaryKey(Long id) {
        LogUtil.info(logger, "收到查询商品请求, id={0}", id);
        AssertUtil.assertNotNull(id, "参数为空");
        Goods goods = goodsDAO.selectByPrimaryKey(id);

        return goods;
    }

    @Override
    @Transactional
    public int insert(Goods goods) {
        LogUtil.info(logger, "收到商品插入请求, goods={0}", goods);
        AssertUtil.assertNotNull(goods, "参数为空");

        return goodsDAO.insert(goods);
    }

    @Override
    @Transactional
    public int updateById(Goods goods) {
        LogUtil.info(logger, "收到商品修改请求, goods={0}", goods);
        AssertUtil.assertNotNull(goods, "参数为空");

        return goodsDAO.updateByPrimaryKey(goods);
    }

}
