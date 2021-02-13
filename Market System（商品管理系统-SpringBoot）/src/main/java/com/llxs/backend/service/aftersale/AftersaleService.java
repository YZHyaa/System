package com.llxs.backend.service.aftersale;

import com.llxs.backend.entity.aftersale.Aftersale;

import java.util.List;

public interface AftersaleService {

    public List<Aftersale> queryAftersale();

    public Aftersale queryAftersaleById(Integer orderId);
}
