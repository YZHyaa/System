package com.llxs.backend.dto;

public class AftersaleVo {

    private String orderId;

    private String questDesc;

    private Integer questType;

    private String questImgs;

    private AftersaleOrderVo order;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }

    public Integer getQuestType() {
        return questType;
    }

    public void setQuestType(Integer questType) {
        this.questType = questType;
    }

    public String getQuestImgs() {
        return questImgs;
    }

    public void setQuestImgs(String questImgs) {
        this.questImgs = questImgs;
    }

    public AftersaleOrderVo getOrder() {
        return order;
    }

    public void setOrder(AftersaleOrderVo order) {
        this.order = order;
    }
}
