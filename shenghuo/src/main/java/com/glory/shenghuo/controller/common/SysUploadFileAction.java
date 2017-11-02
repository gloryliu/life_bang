package com.glory.shenghuo.controller.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApiIgnore
@Controller
@Scope(value="prototype")
@RequestMapping(value="/sys")
public class SysUploadFileAction extends BaseAction {

    @RequestMapping("/uploadGoodsImg")
    public String uploadHeadPic(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        try {
            super.upload(file, "/upload/goodsImg/",request);
            response.getWriter().print(super.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        try {
            super.upload(file, "/upload/user/",request);
            response.getWriter().print(super.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("file")MultipartFile[] file, HttpServletRequest request, HttpServletResponse response){
        try {
            super.uploads(file, "/upload/user/",request);
            response.getWriter().print(super.getFileNames());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
