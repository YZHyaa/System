package com.llxs.backend.service.data;

import com.llxs.backend.entity.data.Data;

import java.util.List;

public interface DataService {

    public List<Data> orderData(String json);

    public List<Data> moneyData(String json);
}
