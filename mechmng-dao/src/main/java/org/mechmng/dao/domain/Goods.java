package org.mechmng.dao.domain;

import org.mechmng.common.util.Money;

public class Goods extends BaseDomain {

    /**  */
    private static final long serialVersionUID = -1110246447342489911L;

    /**
     *  主键, goods.id
     */
    private Long              id;

    /**
     *  商品名称, goods.goodsName
     */
    private String            goodsname;

    /**
     *  价格, goods.price
     */
    private Money             price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}