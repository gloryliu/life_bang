package com.glory.shenghuo.controller.admin;

import com.glory.shenghuo.api.admin.pojo.AdminPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/controller/admin")
public class AdminController {


    @RequestMapping("/admin")
    public String admin(){
        return "admin/index/login";
    }

    @RequestMapping("/index")
    public String loginCheck(){
        return "admin/index/index";
    }

    @RequestMapping("/left")
    public String left(){
        return "admin/index/left";
    }

    @RequestMapping("/head")
    public String head(ModelMap model, HttpServletRequest request){
        AdminPojo adminPojo = (AdminPojo) request.getSession().getAttribute("admin");
        if(adminPojo!=null){
            model.put("adminName",adminPojo.getAdminname());
        }
        return "admin/index/head";
    }

    @RequestMapping("/main")
    public String main(){
        return "admin/index/main";
    }

    @RequestMapping("/login")
    public String login(){
        return "admin/index/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "admin/index/index";
    }

    @RequestMapping("/adminList")
    public String adminList(){
        return "admin/admin/admin_list";
    }

}
