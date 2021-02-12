package com.llxs.backend.dao.admin;

import com.llxs.backend.entity.admin.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {

    public List<Admin> queryAdmins();
}
