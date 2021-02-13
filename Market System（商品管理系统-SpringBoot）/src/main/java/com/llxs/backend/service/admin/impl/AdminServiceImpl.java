package com.llxs.backend.service.admin.impl;

import com.llxs.backend.dao.admin.AdminDao;
import com.llxs.backend.entity.admin.Admin;
import com.llxs.backend.service.admin.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> queryAdmins() {
        return adminDao.queryAdmins();
    }
}
