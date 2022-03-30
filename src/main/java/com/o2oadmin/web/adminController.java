package com.o2oadmin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class adminController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String adminIndex() {
        //首页
        return "/admin/index";
    }
    @RequestMapping(value="/checklogin",method= RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> checkLogin(String loginName, String password, HttpSession session){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        if (loginName!=null || password!=null){
            if ("admin".equals(loginName) && "sc123456".equals(password)){
                session.setAttribute("user",loginName);
                modelMap.put("errMsg", "登陆成功");
                modelMap.put("success",true);
                return modelMap;
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg", "用户名或密码不正确");
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg", "用户名或密码不能为空");
        }
        return modelMap;
    }
}
