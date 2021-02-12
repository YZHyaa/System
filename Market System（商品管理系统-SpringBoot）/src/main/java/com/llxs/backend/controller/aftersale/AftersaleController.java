package com.llxs.backend.controller.aftersale;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llxs.backend.dto.AftersaleListVo;
import com.llxs.backend.dto.AftersaleVo;
import com.llxs.backend.entity.aftersale.Aftersale;
import com.llxs.backend.service.aftersale.AftersaleService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/aftersale")
public class AftersaleController {

    @Resource
    AftersaleService aftersaleService;

    /**
     *售后订单列表
     * @param page 页码
     * @return 售后订单列表
     */
    @GetMapping("query/{page}")
    public ResponseEntity<PageInfo> queryAftersale(@PathVariable("page")Integer page){
        // = 1/3
        PageHelper.startPage(page,10);
        List<Aftersale> aftersales = aftersaleService.queryAftersale();
        List<AftersaleListVo> aftersaleListVoList = JSON.parseArray(JSON.toJSONString(aftersales),AftersaleListVo.class);
        PageInfo pageInfo = new PageInfo(aftersales,5);
        pageInfo.setList(aftersaleListVoList);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 售后订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}/query")
    public ResponseEntity<AftersaleVo> queryAftersaleById(@PathVariable("orderId")Integer orderId){
        Aftersale aftersale = aftersaleService.queryAftersaleById(orderId);
        AftersaleVo aftersaleVo = JSON.parseObject(JSON.toJSONString(aftersale),AftersaleVo.class);

        return ResponseEntity.ok(aftersaleVo);
    }
}
