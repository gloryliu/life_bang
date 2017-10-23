package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class ImageUploadController {

    @RequestMapping("/upload")
    public String upload(){
        return "upload/upload";
    }
}
