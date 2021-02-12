package com.llxs.backend.dao.goods;

import com.llxs.backend.entity.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    public List<Goods> queryGoodsByState(Integer state);

    public List<Goods> queryGoodsByType(Integer typeId);

    public Goods queryGoodsById(Integer goodsId);

    public int updateGoods(Goods goods);

    public int insertGoods(Goods goods);

    public int updateGoodsImg(@Param("goodsImg") String goodsImg, @Param("goodsId") Integer goodsId);

    public Integer queryGoodsIdByName(String name);

    public int deleteGoodsById(Integer goodsId);

    public int updateGoodsStateById(Integer goodsId);

    public int deleteGoods(List<Integer> goodsIds);

    public int updateGoodsState(List<Integer> goodsIds);

    public List<Goods> querySortGoods();
}
