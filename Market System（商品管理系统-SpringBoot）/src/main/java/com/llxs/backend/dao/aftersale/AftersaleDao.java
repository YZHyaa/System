package com.llxs.backend.dao.aftersale;

import com.llxs.backend.entity.aftersale.Aftersale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AftersaleDao {

    public List<Aftersale> queryAftersale();

    public Aftersale queryAftersaleById(Integer orderId);
}
