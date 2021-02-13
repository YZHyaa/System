package com.llxs.backend.controller.data;

import com.llxs.backend.entity.data.Data;
import com.llxs.backend.service.data.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {

    @Resource
    DataService dataService;

    /**
     * 根据日期查询订单数据
     * @param json 起止日期
     * @return 时间段内每天的数据
     */
    @PostMapping("/order")
    public ResponseEntity<List<Data>> orderData(@RequestBody String json){
        List<Data> data = dataService.orderData(json);

        return ResponseEntity.ok(data);
    }

    /**
     * 根据日期查询交易额数据
     * @param json 起止日期
     * @return 时间段内每天的数据
     */
    @PostMapping("/money")
    public ResponseEntity<List<Data>> moneyData(@RequestBody String json){
        List<Data> data = dataService.moneyData(json);

        return ResponseEntity.ok(data);
    }
}
