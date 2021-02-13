package com.llxs.backend.dao.superman;

import com.llxs.backend.entity.superman.Superman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupermanDao {

    public Integer queryExist(String password);

    public Integer query(Superman superman);

}
