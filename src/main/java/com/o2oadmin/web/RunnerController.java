package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.Area;
import com.o2oadmin.entity.LocalAuth;
import com.o2oadmin.entity.PersonInfo;
import com.o2oadmin.entity.Runner;
import com.o2oadmin.service.AreaService;
import com.o2oadmin.service.RunnerService;
import com.o2oadmin.unity.DataGridViewResult;
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
@RequestMapping("/runner")
public class RunnerController {
    @Autowired
    private RunnerService runnerService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/runnerlist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page, int limit, String runnerName,Integer status,Integer userId,Integer getUserId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //System.out.println(runner);
        //调用分页查询列表的方法
        List<Area> areaList = null;
        boolean isrunnerName = "".equals(runnerName)||runnerName == null;
        boolean isstatus = status == null;
        boolean isuserId = userId == null;
        boolean isgetUserId= getUserId==null;
        Runner runner = new Runner();
        if(!isrunnerName){
            runner.setRunnerName(runnerName);
        }
        if(!isstatus){
            runner.setStatus(status);
        }
        if(!isuserId){
            runner.setUserId(Long.valueOf(userId));
        }
        if(!isgetUserId){
            runner.setGetUserId(Long.valueOf(getUserId));
        }
        System.out.println(runner);
        //List<Runner> runners = null;
        List<Runner> runners = runnerService.selectRunnerList(runner);
        //创建分页对象
        PageInfo<Runner> pageInfo = new PageInfo<Runner>(runners);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updaterunner")
    @ResponseBody
    public Map<String,Object> updaterunner(Runner runner){
        System.out.println(runner);
        Map<String,Object> map = new HashMap<String,Object>();
        //runner.setLastEditTime(new Date());
        //System.out.println(area);
        Integer stat = runnerService.selectRunnerByRunnerId(runner.getRunnerId()).getStatus();
        if (stat != runner.getStatus()){
        if (runner.getGetUserId()==null){
            map.put("success",false);
            map.put("message","修改失败，请检查是否有人接单");
            return map;
        }}
        try {
            if(runnerService.updateRunner(runner)>0){
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
    @RequestMapping("/deletearea")
    @ResponseBody
    public Map<String,Object> deletearea(Long areaId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(areaService.deleteAreaByAreaId(areaId)>0){
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
    @RequestMapping("/batchdeletearea")
    @ResponseBody
    public Map<String,Object> batchdeletearea(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(areaService.deleteAreaByAreaIds(ids)>0){
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
