package com.llxs.backend.dao.order;

import com.llxs.backend.dto.OrderVo;
import com.llxs.backend.entity.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderDao {

    public List<Order> queryOrders();

    public List<Order> queryOrdersByState(Integer state);

    public int updateOrders(@Param("orderId") String orderId, @Param("state") Integer state);

    public List<Order> querySearchOrders(String content);

    public Order queryOrderById(String orderId);

    public List<Order> queryOrderBydate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);


}
