package com.llxs.backend.dto;

import com.llxs.backend.entity.goods.Goods;

public class OrderDetailVo {

    private double detailPrice;

    private String detailNum;

    private GoodsVo goods;

    public double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(double detailPrice) {
        this.detailPrice = detailPrice;
    }

    public String getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(String detailNum) {
        this.detailNum = detailNum;
    }


    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
}
