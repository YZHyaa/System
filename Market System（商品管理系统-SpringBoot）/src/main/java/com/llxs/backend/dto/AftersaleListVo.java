package com.llxs.backend.dto;

public class AftersaleListVo {

    private String orderId;

    private OrderVo order;

    private String questDesc;

    private OrderDetailVo orderDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderVo getOrder() {
        return order;
    }

    public void setOrder(OrderVo order) {
        this.order = order;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }

    public OrderDetailVo getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetailVo orderDetails) {
        this.orderDetails = orderDetails;
    }
}
