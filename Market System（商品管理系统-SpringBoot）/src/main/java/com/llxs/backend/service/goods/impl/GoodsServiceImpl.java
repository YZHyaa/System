package com.llxs.backend.service.goods.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.llxs.backend.dao.goods.GoodsDao;
import com.llxs.backend.dao.goods.GoodsDetailDao;
import com.llxs.backend.entity.goods.Goods;
import com.llxs.backend.entity.goods.GoodsDetail;
import com.llxs.backend.service.goods.GoodsService;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsDao goodsDao;
    @Resource
    GoodsDetailDao goodsDetailDao;

    @Override
    public List<Goods> queryGoodsByState(Integer state) {

        return goodsDao.queryGoodsByState(state);
    }

    @Override
    public List<Goods> queryGoodsByType(Integer typeId) {
        return goodsDao.queryGoodsByType(typeId);
    }

    @Override
    public Map<String,Object> queryGoodsById(Integer goodsId) {

        Map<String,Object> map = new HashMap<>();
        BeanMap goodsMap = BeanMap.create(goodsDao.queryGoodsById(goodsId));
        for(Object key: goodsMap.keySet()){
            map.put(key+"",goodsMap.get(key));
        }
        BeanMap detailMap= BeanMap.create(goodsDetailDao.queryGoodsDetailById(goodsId));
        for(Object key : detailMap.keySet()){
            map.put(key+"",detailMap.get(key));
        }

        return map;
    }

    @Override
    public boolean updateGoods(String json) {

        Goods goods = JSON.parseObject(json,Goods.class);
        GoodsDetail goodsDetail = JSON.parseObject(json,GoodsDetail.class);
        goodsDetail.setGoodId(goods.getGoodsId());

        return goodsDao.updateGoods(goods)>0 && goodsDetailDao.updateGoodsDetail(goodsDetail)>0;
    }

    @Override
    public boolean insertGoods(String json) {

        Goods goods = JSON.parseObject(json,Goods.class);
        if(goodsDao.queryGoodsIdByName(goods.getGoodsName()) != null){
            return false;
        }
        goodsDao.insertGoods(goods);
        GoodsDetail goodsDetail = JSON.parseObject(json,GoodsDetail.class);
        goodsDetail.setGoodId(goodsDao.queryGoodsIdByName(goods.getGoodsName()));

        return goodsDetailDao.insertGoodsDetail(goodsDetail)>0;
    }

    @Override
    public boolean doGoodsImg(String goodsImg, String goodsName) {
        return goodsDao.updateGoodsImg(goodsImg,goodsDao.queryGoodsIdByName(goodsName))>0;
    }


    @Override
    public boolean deleteGoodsById(Integer goodsId) {
        return goodsDetailDao.deleteGoodsDetailById(goodsId)>0 && goodsDao.deleteGoodsById(goodsId)>0 ;
    }

    @Override
    public boolean undercarriageById(Integer goodsId) {

        return goodsDao.updateGoodsStateById(goodsId)>0;
    }

    @Override
    public boolean deleteGoods(String json) {
        List<Integer> del_goodsIds = new ArrayList<>();
        JSONObject jsonObject = JSON.parseObject(json);
        String[] goodsIds = jsonObject.getString("goodsIds").split("-");
        for(String id : goodsIds){
            del_goodsIds.add(Integer.parseInt(id));
        }

        return goodsDetailDao.deleteGoodsDetail(del_goodsIds)>0 && goodsDao.deleteGoods(del_goodsIds)>0;
    }

    @Override
    public boolean undercarriage(String json) {
        List<Integer> update_goodsIds = new ArrayList<>();
        JSONObject jsonObject = JSON.parseObject(json);
        String[] goodsIds = jsonObject.getString("goodsIds").split("-");
        for(String id : goodsIds){
            update_goodsIds.add(Integer.parseInt(id));
        }

        return goodsDao.updateGoodsState(update_goodsIds)>0;
    }

    @Override
    public List<Goods> sortGoods() {
        return goodsDao.querySortGoods();
    }
}
