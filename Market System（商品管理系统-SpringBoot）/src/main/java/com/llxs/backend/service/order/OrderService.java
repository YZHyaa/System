package com.llxs.backend.service.order;

import com.llxs.backend.dto.OrderVo;
import com.llxs.backend.entity.order.Order;

import java.util.List;

public interface OrderService {

    public List<Order> queryOrders();

    public List<Order> queryOrdersByState(Integer state);

    public boolean updateOrders(String orderId,Integer state);

    public List<Order> searchOrders(String content);

    public Order queryOrderById(String orderId);

    public List<Order> queryOrderBydate(String json);
}
