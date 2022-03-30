package com.o2oadmin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/manage")
public class manageController {

        @RequestMapping(value = "/area",method = RequestMethod.GET)
        public String area() {
            //首页
            return "/manage/areamanage";
        }
}
