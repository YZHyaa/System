package com.llxs.backend.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llxs.backend.entity.admin.Admin;
import com.llxs.backend.service.admin.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    /**
     * 查询会员列表
     * @param page 页码
     * @return
     */
    @GetMapping("/query/{page}")
    public ResponseEntity<PageInfo> queryAdmins(@PathVariable("page")Integer page) {
        PageHelper.startPage(page, 10);
        List<Admin> admins = adminService.queryAdmins();
        PageInfo pageInfo = new PageInfo(admins);
        if(page > pageInfo.getPages()){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(pageInfo);
    }
}
