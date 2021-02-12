package com.llxs.backend.service.aftersale.impl;

import com.llxs.backend.dao.aftersale.AftersaleDao;
import com.llxs.backend.entity.aftersale.Aftersale;
import com.llxs.backend.service.aftersale.AftersaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AftersaleServiceImpl implements AftersaleService {

    @Resource
    AftersaleDao aftersaleDao;

    @Override
    public List<Aftersale> queryAftersale() {
        return aftersaleDao.queryAftersale();
    }

    @Override
    public Aftersale queryAftersaleById(Integer orderId) {
        return aftersaleDao.queryAftersaleById(orderId);
    }
}
