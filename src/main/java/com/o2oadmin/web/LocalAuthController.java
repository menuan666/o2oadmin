package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.LocalAuth;
import com.o2oadmin.service.LocalAuthService;
import com.o2oadmin.util.DataGridViewResult;
import com.o2oadmin.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/localauth")
public class LocalAuthController {
    @Autowired
    private LocalAuthService localAuthService;

    @RequestMapping(value = "/localauthlist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,String username,Integer userId) {
        System.out.println(userId);
        System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        boolean isusername = "".equals(username)||username == null;
        boolean isuserid = userId==null;
        LocalAuth lo = new LocalAuth();
        if(!isusername){
            lo.setUsername(username);
        }
        if(!isuserid){
            lo.setUserId(Long.valueOf(userId));
        }
        List<LocalAuth> localauthList = null;
        localauthList = localAuthService.selectLocalAuthList(lo);
        //创建分页对象
        PageInfo<LocalAuth> pageInfo = new PageInfo<LocalAuth>(localauthList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updatelocalauth")
    @ResponseBody
    public Map<String,Object> updatearea(LocalAuth localAuth){
        System.out.println(localAuth);
        Map<String,Object> map = new HashMap<String,Object>();
        localAuth.setLastEditTime(new Date());
        System.out.println(localAuth);
        localAuth.setPassword(MD5.getMd5(localAuth.getPassword()));
        if(localAuthService.updateLocalAuth(localAuth)>0){
            map.put("success",true);
            map.put("message","修改成功");
        }else{
            map.put("success",false);
            map.put("message","修改失败");
        }
        return map;
    }
}
