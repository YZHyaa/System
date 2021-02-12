package com.llxs.backend.service.superman.impl;

import com.alibaba.fastjson.JSON;
import com.llxs.backend.dao.superman.SupermanDao;
import com.llxs.backend.entity.superman.Superman;
import com.llxs.backend.service.superman.SupermanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupermanServiceImpl implements SupermanService {

    @Resource
    SupermanDao supermanDao;

    @Override
    public boolean exist(String json) {

        Superman superman = JSON.parseObject(json,Superman.class);
        return supermanDao.queryExist(superman.getUsername()) != null;
    }

    @Override
    public boolean login(String json) {

        Superman superman = JSON.parseObject(json,Superman.class);
        return supermanDao.query(superman) != null;
    }
}
