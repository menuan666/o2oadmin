package com.o2oadmin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manage")
public class manageController {

    @RequestMapping(value = "/area", method = RequestMethod.GET)
    public String area() {
        //首页
        return "/manage/areamanage";
    }
    @RequestMapping(value = "/localauth", method = RequestMethod.GET)
    public String localauth() {
        //首页
        return "/manage/localauthmanage";
    }
    @RequestMapping(value = "/personinfo", method = RequestMethod.GET)
    public String personinfo() {
        //首页
        return "/manage/personinfomanage";
    }
    @RequestMapping(value = "/runner", method = RequestMethod.GET)
    public String runner() {
        //首页
        return "/manage/runnermanage";
    }
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        //首页
        return "/manage/ordermanage";
    }
    @RequestMapping(value = "/productimg", method = RequestMethod.GET)
    public String productimg() {
        //首页
        return "/manage/productimgmanage";
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product() {
        //首页
        return "/manage/productmanage";
    }
    @RequestMapping(value = "/productcategory", method = RequestMethod.GET)
    public String productcategory() {
        //首页
        return "/manage/productcategorymanage";
    }
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shop() {
        //首页
        return "/manage/shopmanage";
    }
    @RequestMapping(value = "/headline", method = RequestMethod.GET)
    public String headline() {
        //首页
        return "/manage/headlinemanage";
    }
    @RequestMapping(value = "/shopcategory", method = RequestMethod.GET)
    public String shopcategory() {
        //首页
        return "/manage/shopcategorymanage";
    }
}
