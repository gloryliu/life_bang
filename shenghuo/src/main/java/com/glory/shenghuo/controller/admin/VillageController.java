package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller/village")
public class VillageController {

    @RequestMapping("/addVillage")
    public String addVillage(){
        return "village/village";
    }
}
