package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.PersonInfo;
import com.o2oadmin.service.LocalAuthService;
import com.o2oadmin.service.PersonInfoService;
import com.o2oadmin.util.DataGridViewResult;
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
@RequestMapping("/personinfo")
public class PersonInfoController {
    @Autowired
    private LocalAuthService localAuthService;
    @Autowired
    private PersonInfoService personInfoService;

    @RequestMapping(value = "/personinfolist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,String name, String email, String gender,Integer enableStatus) {
        System.out.println("page:"+page+",limit:"+limit+",name:"+name+",email:"+email+",gender:"+gender+",enableStatus:"+enableStatus);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        boolean isname = "".equals(name)||name == null;
        boolean isemail = "".equals(email)||email == null;
        boolean isgender = "".equals(gender)||gender == null;
        boolean isenableStatus= enableStatus==null;
        PersonInfo personInfo = new PersonInfo();
        if(!isname){
            personInfo.setName(name);
        }
        if(!isemail){
            personInfo.setEmail(email);
        }
        if(!isgender){
            personInfo.setGender(gender);
        }
        if(!isenableStatus){
            personInfo.setEnableStatus(enableStatus);
        }
        //List<LocalAuth> localauthList = null;
        List<PersonInfo> personInfos = personInfoService.selectPersonInfoList(personInfo);
        //创建分页对象
        PageInfo<PersonInfo> pageInfo = new PageInfo<PersonInfo>(personInfos);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updatepersoninfo")
    @ResponseBody
    public Map<String,Object> updatearea(PersonInfo personInfo){
        System.out.println(personInfo);
        Map<String,Object> map = new HashMap<String,Object>();
        personInfo.setLastEditTime(new Date());
        System.out.println(personInfo);
        //personInfo.setPassword(MD5.getMd5(localAuth.getPassword()));
        try {
        if(personInfoService.updatePersonInfo(personInfo)>0){
            map.put("success",true);
            map.put("message","修改成功");
        }else{
            map.put("success",false);
            map.put("message","修改失败");
        }
        }catch(Exception e){
            map.put("success",false);
            map.put("message","请检查数据库");
        }
        return map;
    }
    @RequestMapping("/deletepersoninfo")
    @ResponseBody
    public Map<String,Object> deletepersoninfo(Long userId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(personInfoService.deletePersonInfoByUserId(userId)>0){
                map.put("success",true);
                map.put("message","删除成功");
            }else{
                map.put("success",false);
                map.put("message","删除失败");
            }
        }catch(Exception e){
            map.put("success",false);
            map.put("message","请检查数据库");
        }
        return map;
    }
    @RequestMapping("/batchdeletepersoninfo")
    @ResponseBody
    public Map<String,Object> batchdeletepersoninfo(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(personInfoService.deletePersonInfoByUserIds(ids)>0){
                map.put("success",true);
                map.put("message","批量删除成功");
            }else{
                map.put("success",false);
                map.put("message","批量删除失败");
            }
        }catch(Exception e){
            map.put("success",false);
            map.put("message","请检查数据库");
        }
        return map;
    }
}
