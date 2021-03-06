package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.Area;
import com.o2oadmin.service.AreaService;
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
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/arealist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,String areaName) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        List<Area> areaList = null;
        if ("".equals(areaName)||areaName == null){
            areaList = areaService.selectAreaList(new Area());
        }else{
            areaList = areaService.selectAreaList(new Area().setAreaName(areaName));
        }
        //创建分页对象
        PageInfo<Area> pageInfo = new PageInfo<Area>(areaList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }
    @RequestMapping("/addarea")
    @ResponseBody
    public Map<String,Object> addarea(Area area){
        Map<String,Object> map = new HashMap<String,Object>();
        area.setCreateTime(new Date());
        if(areaService.insertArea(area)>0){
            map.put("success",true);
            map.put("message","添加成功");
        }else{
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }
    @RequestMapping("/updatearea")
    @ResponseBody
    public Map<String,Object> updatearea(Area area){
        System.out.println(area);
        Map<String,Object> map = new HashMap<String,Object>();
        area.setLastEditTime(new Date());
        System.out.println(area);
        try {
            if(areaService.updateArea(area)>0){
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
