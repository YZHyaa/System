package com.llxs.backend.entity.aftersale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.llxs.backend.entity.order.Order;
import com.llxs.backend.entity.order.OrderDetail;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Aftersale {
    private Integer id;

    private String orderId;

    private Integer orderdetId;

    private Integer userId;

    private Integer goodsId;

    private String goodsName;

    private Integer count;

    private double goodsPrice;

    private double money;

    private Integer questType;

    private String questDesc;

    private String questImgs;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date questDate;

    private Integer status;

    private Order order;

    private List<OrderDetail> orderDetails;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderdetId() {
        return orderdetId;
    }

    public void setOrderdetId(Integer orderdetId) {
        this.orderdetId = orderdetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getQuestType() {
        return questType;
    }

    public void setQuestType(Integer questType) {
        this.questType = questType;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }

    public String getQuestImgs() {
        return questImgs;
    }

    public void setQuestImgs(String questImgs) {
        this.questImgs = questImgs;
    }

    public Date getQuestDate() {
        return questDate;
    }

    public void setQuestDate(Date questDate) {
        this.questDate = questDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
