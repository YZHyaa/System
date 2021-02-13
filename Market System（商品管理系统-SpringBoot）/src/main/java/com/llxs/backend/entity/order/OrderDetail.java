package com.llxs.backend.entity.order;

import com.llxs.backend.entity.goods.Goods;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.List;

public class OrderDetail {

    private Integer detailId;

    private String detailOrder;

    private Integer detailGoods;

    private double detailPrice;

    private String detailNum;

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(String detailOrder) {
        this.detailOrder = detailOrder;
    }

    public Integer getDetailGoods() {
        return detailGoods;
    }

    public void setDetailGoods(Integer detailGoods) {
        this.detailGoods = detailGoods;
    }

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


    @Override
    public String toString() {
        return "OrderDetail{" +
                ", detailPrice=" + detailPrice +
                ", detailNum='" + detailNum + '\'' +
                ", goods=" + goods +
                '}';
    }
}
