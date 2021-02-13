package com.llxs.backend.dao.data;

import com.llxs.backend.entity.data.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DataDao {

    public List<Data> queryOrderData(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    public List<Data> queryMoneyData(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
