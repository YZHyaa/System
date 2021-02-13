package com.llxs.backend.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llxs.backend.entity.goods.Goods;
import com.llxs.backend.service.goods.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    /**
     * 显示在售/下架商品
     * @param state 商品状态（1.正常，2热卖，-1删除）
     * @param page 要显示的页码
     * @return 返回商品清单
     */
    @GetMapping("/query/{state}/{page}")
    public ResponseEntity<PageInfo> queryGoodsByState(@PathVariable("state") Integer state,@PathVariable("page") Integer page){
        PageHelper.startPage(page,7);
        List<Goods> goods = goodsService.queryGoodsByState(state);
        PageInfo pageInfo = new PageInfo(goods,5);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
}

    /**
     * 根据分类查询
     * @param typeId 商品分类（1.蔬菜）
     * @param page 当前页码
     * @return 返回商品清单
     */
    @GetMapping("/queryByType/{typeId}/{page}")
    public ResponseEntity<PageInfo> queryGoodsByType(@PathVariable("typeId") Integer typeId,@PathVariable("page") Integer page){
        PageHelper.startPage(page,7);
        List<Goods> goods = goodsService.queryGoodsByType(typeId);
        PageInfo pageInfo = new PageInfo(goods,5);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 查询指定商品信息
     * @param goodsId 商品Id
     * @return
     */
    @GetMapping("/queryById/{goodsId}")
    public ResponseEntity<Map<String,Object>> queryGoodsById(@PathVariable("goodsId")Integer goodsId){
        Map<String,Object> map = goodsService.queryGoodsById(goodsId);

        return ResponseEntity.ok(map);
    }

    /**
     * 编辑指定商品
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateGoods(@RequestBody String json){

        if(goodsService.updateGoods(json)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 添加商品
     * @param json
     * @return
     */
    @PostMapping("/insert")
    public ResponseEntity<String> insertGoods(@RequestBody String json){

        if(goodsService.insertGoods(json)){
            return ResponseEntity.ok(null);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("商品已存在！");
        }
    }

    /*
        上传图片
     */
    @PostMapping("/doImg")
    public ResponseEntity<Void> insertGoodsImg(@RequestParam("file")MultipartFile[] file,@RequestParam("goodsName") String goodsName){
        String goodsImg = "";
        StringBuilder path = new StringBuilder();
        //String location = "C:\\Users\\13275\\Documents\\Uploads\\linlixs";
        //String url = "http://xuptyzh.goho.co:30303/imgs/";
        String location = "/java/images/";
        String url = "http://xuptyzh.xyz:8080/imgs/";

        {File dir = new File(location);
        if(!dir.exists()){
            dir.mkdirs();
        }}

        if(file != null) {
            for (MultipartFile mf : file) {
                if (!mf.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
                    String date = sdf.format(new Date());
                    String originalFilename = mf.getOriginalFilename();
                    String filename = date+originalFilename.substring(originalFilename.lastIndexOf('.'));
                    File newFile = new File(location, filename);
                    try {
                        mf.transferTo(newFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    path.append(url + filename + ",");
                }
            }
        }
        if( path.length() > 0){
            path.deleteCharAt(path.lastIndexOf(","));
            goodsImg = path + "";
        }

        if(goodsService.doGoodsImg(goodsImg,goodsName)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /*
        删除指定商品
     */
    @DeleteMapping("/delete/{goodsId}")
    public ResponseEntity<Void> deleteGoodsById(@PathVariable("goodsId")Integer goodsId){
        if(goodsService.deleteGoodsById(goodsId)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /*
        下架指定商品
     */
    @GetMapping("/undercarriage/{goodsId}")
    public ResponseEntity<Void> undercarriageById(@PathVariable("goodsId")Integer goodsId){
        if(goodsService.undercarriageById(goodsId)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 批量删除
     * @param json 商品Id字符串 ’-’隔开
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteGoods(@RequestBody String json){

        if(goodsService.deleteGoods(json)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 批量下架
     * @param json 商品Id字符串 ’-’隔开
     * @return
     */
    @PostMapping("/undercarriage")
    public ResponseEntity<Void> undercarriage(@RequestBody String json){

        if(goodsService.undercarriage(json)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Goods>> sortGoods(){
        List<Goods> goods = goodsService.sortGoods();
        return ResponseEntity.ok(goods);
    }

}
