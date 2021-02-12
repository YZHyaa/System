package com.llxs.backend.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.llxs.backend.entity.goods.Goods;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {

    private String orderId;

    private Integer orderUser;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderDate;

    private double orderPrice;

    private Integer orderState;

    private String orderUserName;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderPrice=" + orderPrice +
                ", orderState=" + orderState +
                ", orderUserName='" + orderUserName + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderExpressNo='" + orderExpressNo + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    private String orderPhone;

    private String orderAddress;

    private String orderExpressNo;

    private List<OrderDetail> orderDetails;


    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderExpressNo() {
        return orderExpressNo;
    }

    public void setOrderExpressNo(String orderExpressNo) {
        this.orderExpressNo = orderExpressNo;
    }
}
