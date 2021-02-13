package com.llxs.backend;

import com.llxs.backend.dao.data.DataDao;
import com.llxs.backend.dao.order.OrderDao;
import com.llxs.backend.dao.superman.SupermanDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

    @Resource
    SupermanDao supermanDao;
    @Resource
    OrderDao orderDao;
    @Resource
    DataDao dataDao;

    @Test
    public void contextLoads() {

//        System.out.println(supermanDao);
//        System.out.println(orderDao);
//        System.out.println(orderDao.queryOrders());
//        System.out.println(dataDao.queryOrderData("2019-05-21","2019-05-25"));

//        System.out.println(orderDao.queryOrders());
    }

}
