package com.glory.shenghuo.controller.index;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@ApiIgnore
@Controller
public class ShenghuoController {

    @RequestMapping("/test")
    public String wanba(){
        return "index/index";
    }

    @RequestMapping("/ueditor/webPath")
    public void webPath(String action,String noCache,HttpServletRequest request, HttpServletResponse response){
        try {

            request.setCharacterEncoding( "utf-8" );
            response.setHeader("Content-Type" , "text/html");

            String path = request.getContextPath();

            PrintWriter out = response.getWriter();

            out.write( new ActionEnter( request, path ).exec() );

        }catch (Exception e){

        }


    }

}
