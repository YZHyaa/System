package com.llxs.backend.entity.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GoodsDetail {

    private Integer goodId;

    private String goodArea;

    private Integer goodContent;

    private Integer goodDate;

    private String goodKeep;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodArea() {
        return goodArea;
    }

    public void setGoodArea(String goodArea) {
        this.goodArea = goodArea;
    }

    public Integer getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(Integer goodContent) {
        this.goodContent = goodContent;
    }

    public Integer getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(Integer goodDate) {
        this.goodDate = goodDate;
    }

    public String getGoodKeep() {
        return goodKeep;
    }

    public void setGoodKeep(String goodKeep) {
        this.goodKeep = goodKeep;
    }
}
