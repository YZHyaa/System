package com.llxs.backend.controller.order;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llxs.backend.dto.OrderVo;
import com.llxs.backend.entity.order.Order;
import com.llxs.backend.service.order.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    /**
     * 查询所有订单
     * @param page 页码
     * @return 订单列表
     */
    @GetMapping("/query/{page}")
    public ResponseEntity<PageInfo> queryOrders(@PathVariable("page")Integer page){
        //由于关联查询所以 < 1/4 pageSize
        PageHelper.startPage(page,12);
        List<Order> orders = orderService.queryOrders();
        List<OrderVo> orderVos = JSON.parseArray(JSON.toJSONString(orders), OrderVo.class);
//        List<OrderVo> orderVos = orders.stream().map(order -> {
//            OrderVo orderVo = new OrderVo();
//            BeanUtils.copyProperties(order,orderVo);
//            return orderVo;
//        }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(orders,5);
        pageInfo.setList(orderVos);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 根据订单状态查询
     * @param state 订单状态(-1删除 1 待付款 2待发货 3 待收货 4待评价 5完成)
     * @param page 页码
     * @return 订单列表
     */
    @GetMapping("/query/{state}/{page}")
    public ResponseEntity<PageInfo> queryOrdersByState(@PathVariable("state")Integer state,@PathVariable("page")Integer page){
        PageHelper.startPage(page,10);
        List<Order> orders = orderService.queryOrdersByState(state);
        List<OrderVo> orderVos = JSON.parseArray(JSON.toJSONString(orders),OrderVo.class);
        PageInfo pageInfo = new PageInfo(orders,5);
        pageInfo.setList(orderVos);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 修改订单状态
     * @param orderId 订单id
     * @param state 要修改成的状态
     * @return
     */
    @GetMapping("/update/{orderId}/{state}")
    public ResponseEntity<Void> updateOrders(@PathVariable("orderId")String orderId,@PathVariable("state")Integer state){
        if(orderService.updateOrders(orderId,state)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 搜索框
     * @param content 搜索的参数（用户名/订单号）
     * @param page 当前页码
     * @return 订单列表
     */
    @GetMapping("/search/{content}/{page}")
    public ResponseEntity<PageInfo> searchOrders(@PathVariable("content")String content,@PathVariable("page")Integer page){
        PageHelper.startPage(page,10);
        List<Order> orders = orderService.searchOrders(content);
        List<OrderVo> orderVos = JSON.parseArray(JSON.toJSONString(orders),OrderVo.class);
        PageInfo pageInfo = new PageInfo(orders,5);
        pageInfo.setList(orderVos);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }

    /*
        查看具体订单
     */
    @GetMapping("/{orderId}/query")
    public ResponseEntity<OrderVo> queryOrderById(@PathVariable("orderId")String orderId){
        Order order = orderService.queryOrderById(orderId);
        OrderVo orderVo = JSON.parseObject(JSON.toJSONString(order),OrderVo.class);
        return ResponseEntity.ok(orderVo);
    }

    /**
     * 查询指定时间段内的订单
     * @param json 起止时间
     * @return 订单列表
     */
    @PostMapping("/queryBydate/{page}")
    public ResponseEntity<PageInfo> queryOrderBydate(@PathVariable("page")Integer page, @RequestBody String json){
        PageHelper.startPage(page,12);
        List<Order> orders = orderService.queryOrderBydate(json);
        List<OrderVo> orderVos = JSON.parseArray(JSON.toJSONString(orders),OrderVo.class);
        PageInfo pageInfo = new PageInfo(orders,5);
        pageInfo.setList(orderVos);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }

}
