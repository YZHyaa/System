package com.llxs.backend.entity.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Data {

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date theDate;

    private double dataNum;

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    public double getDataNum() {
        return dataNum;
    }

    public void setDataNum(double dataNum) {
        this.dataNum = dataNum;
    }
}
