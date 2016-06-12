/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service;

import org.mechmng.common.facade.result.PageList;
import org.mechmng.dao.domain.Goods;

/**
 * 商品的服务类
 * @author HuHui
 * @version $Id: GoodsService.java, v 0.1 2016年6月12日 下午8:49:45 HuHui Exp $
 */
public interface GoodsService {

    /**
     * 根据商品id获取商品
     * @param id
     * @return
     */
    Goods selectByPrimaryKey(Long id);

    /**
     * 插入商品记录
     * @param goods
     * @return
     */
    int insert(Goods goods);

    /**
     * 根据主键修改商品信息
     * @param goods
     * @return
     */
    int updateById(Goods goods);

    /**
     * 查询商品，带分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageList<Goods> getGoods(int pageNum, int pageSize);

}
