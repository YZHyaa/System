package com.llxs.backend.service.goods;

import com.llxs.backend.entity.goods.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public List<Goods> queryGoodsByState(Integer state);

    public List<Goods> queryGoodsByType(Integer typeId);

    /*
        queryGoodsDetailById+queryGoodsById
     */
    public Map<String,Object> queryGoodsById(Integer goodsId);

    /*
        updateGoodsDetail+updateGoods
     */
    public boolean updateGoods(String json);

    /*
        insertGoods+queryGoodsIdByName+insertGoodsDetail
     */
    public boolean insertGoods(String json);

    public boolean doGoodsImg(String goodsImg,String goodsName);

    /*
        deleteGoodsById+deleteGoodsDetailById
     */
    public boolean deleteGoodsById(Integer goodsId);

    public boolean undercarriageById(Integer goodsId);

    /*
        deleteGoods+deleteGoodsDetail
     */
    public boolean deleteGoods(String json);

    public boolean undercarriage(String json);

    public List<Goods> sortGoods();

}
