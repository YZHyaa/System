package com.llxs.backend.service.order.impl;

import com.alibaba.fastjson.JSONObject;
import com.llxs.backend.dao.order.OrderDao;
import com.llxs.backend.dto.OrderVo;
import com.llxs.backend.entity.order.Order;
import com.llxs.backend.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Override
    public List<Order> queryOrders() {

        return orderDao.queryOrders();
    }

    @Override
    public List<Order> queryOrdersByState(Integer state) {
        return orderDao.queryOrdersByState(state);
    }

    @Override
    public boolean updateOrders(String orderId, Integer state) {
        return orderDao.updateOrders(orderId,state)>0;
    }

    @Override
    public List<Order> searchOrders(String content) {
        return orderDao.querySearchOrders(content);
    }

    @Override
    public Order queryOrderById(String orderId) {
        return orderDao.queryOrderById(orderId);
    }

    @Override
    public List<Order> queryOrderBydate(String json) {

        List<Order> list = null;

        JSONObject jsonObject = JSONObject.parseObject(json);
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            list = orderDao.queryOrderBydate(sdf.parse(startTime),sdf.parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }
}
