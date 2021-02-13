package com.llxs.backend.service.data.impl;

import com.alibaba.fastjson.JSONObject;
import com.llxs.backend.dao.data.DataDao;
import com.llxs.backend.entity.data.Data;
import com.llxs.backend.service.data.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource
    DataDao dataDao;


    @Override
    public List<Data> orderData(String json) {

        List<Data> list = null;
        JSONObject jsonObject = JSONObject.parseObject(json);
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            list = dataDao.queryOrderData(sdf.parse(startTime),sdf.parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Data> moneyData(String json) {

        List<Data> list = null;
        JSONObject jsonObject = JSONObject.parseObject(json);
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            list = dataDao.queryMoneyData(sdf.parse(startTime),sdf.parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
