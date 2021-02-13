package com.llxs.backend.dao.goods;

import com.llxs.backend.entity.goods.GoodsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDetailDao {

    public GoodsDetail queryGoodsDetailById(Integer goodsId);

    public int updateGoodsDetail(GoodsDetail goodsDetail);

    public int insertGoodsDetail(GoodsDetail goodsDetail);

    public int deleteGoodsDetailById(Integer goodsId);

    public int deleteGoodsDetail(List<Integer> goodsIds);
}
