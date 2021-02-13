package com.llxs.backend.entity.goods;

public class Goods {

    private Integer goodsId;

    private String goodsName;

    private Double goodsPrice;
    /**
     * Num 表示数量
     */
    private Integer goodsNum;
    /**
     * goodsType 它的类型
     */
    private Integer goodsType;
    /**
     * goods的图片URL
     */
    private String goodsImg;
    /**
     * goods的状态 正常出售 热销 一些列
     */
    private Integer goodsState;
    /**
     * 描述
     */
    private String goodsDesc;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsNum=" + goodsNum +
                ", goodsType=" + goodsType +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsState=" + goodsState +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsVolume=" + goodsVolume +
                '}';
    }

    public Goods() {
    }

    /**
     * 销量
     */
    private Integer goodsVolume;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(Integer goodsVolume) {
        this.goodsVolume = goodsVolume;
    }
}
