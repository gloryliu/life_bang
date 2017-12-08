package com.glory.shenghuo.controller.common;

import com.glory.shenghuo.common.MyResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@Scope(value="prototype")
@Api(value = "upload", description = "系统上传图片")
@RequestMapping(value="/sys")
public class SysUploadFileAction extends BaseAction {

    @ApiIgnore
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

    @ApiOperation("上传用户头像")
    @RequestMapping(value = "/uploadUserImg",method = RequestMethod.POST)
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        super.upload(file, "/upload/userHead/",request);
        result = super.getFileName();
        return MyResponseUtil.ok((Object)result);
    }

    @ApiIgnore
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
