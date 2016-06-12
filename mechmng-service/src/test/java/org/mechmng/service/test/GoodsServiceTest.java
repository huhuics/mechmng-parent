/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.service.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mechmng.common.util.Money;
import org.mechmng.dao.domain.Goods;
import org.mechmng.service.GoodsService;

/**
 * 
 * @author HuHui
 * @version $Id: GoodsServiceTest.java, v 0.1 2016年6月12日 下午8:55:18 HuHui Exp $
 */
public class GoodsServiceTest extends BaseTest {

    @Resource
    private GoodsService goodsService;

    @Test
    public void testSelectById() {
        Assert.assertNotNull(goodsService);
        Goods goods = goodsService.selectByPrimaryKey(1L);
        Assert.assertNotNull(goods);
        Assert.assertTrue(goods.getId() == 1L);
    }

    @Test
    public void testInsert() {
        Assert.assertNotNull(goodsService);
        Money money = new Money(5, 30);
        Goods goods = new Goods();
        goods.setGoodsname("油桃");
        goods.setPrice(money);
        int count = goodsService.insert(goods);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testUpdate() {
        Assert.assertNotNull(goodsService);
        Goods goods = goodsService.selectByPrimaryKey(1L);
        goods.setPrice(new Money(1, 60));
        int count = goodsService.updateById(goods);
        Assert.assertTrue(count > 0);
    }

}
