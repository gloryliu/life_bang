package com.glory.shenghuo.resource.web;


import com.glory.shenghuo.api.admin.pojo.AdminPojo;
import com.glory.shenghuo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource/admin")
@ApiIgnore
public class AdminResource {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/loginCheck",method = RequestMethod.GET)
    public int loginCheck(HttpSession session, String adminname, String adminpwd){
        Map<String,String> param = new HashMap<>();
        param.put("adminname",adminname);
        param.put("adminpwd",adminpwd);
        AdminPojo adminPojo = adminService.getAdminByMap(param);
        if(adminPojo == null){
            return 1;
        } else {
            session.setAttribute("admin",adminPojo);
            return 2;

        }
    }

    @RequestMapping(value = "/getAllList",method = RequestMethod.GET)
    public List<AdminPojo> getAllList(){
        return adminService.getAllList();
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    public int deleteById(int id){
        return adminService.deleteById(id);
    }

    @RequestMapping("/update")
    public int update(AdminPojo adminPojo){
        return adminService.update(adminPojo);
    }

    @RequestMapping("/insert")
    public int insert(AdminPojo adminPojo){
        return adminService.insert(adminPojo);
    }

}
