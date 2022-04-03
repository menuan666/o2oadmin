package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.Area;
import com.o2oadmin.entity.Order;
import com.o2oadmin.entity.Runner;
import com.o2oadmin.service.AreaService;
import com.o2oadmin.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orderlist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page, int limit, String productName,Integer status,Integer userId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //System.out.println(runner);
        //调用分页查询列表的方法
        List<Area> areaList = null;
        boolean isproductName = "".equals(productName)||productName == null;
        boolean isstatus = status == null;
        boolean isuserId = userId == null;
        Order order = new Order();
        if(!isproductName){
            order.setProductName(productName);
        }
        if(!isstatus){
            order.setStatus(status);
        }
        if(!isuserId){
            order.setUserId(Long.valueOf(userId));
        }
        System.out.println(order);
        //List<Runner> runners = null;
        List<Order> orders = orderService.selectorderList(order);
        //创建分页对象
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }


    @RequestMapping("/deleteorder")
    @ResponseBody
    public Map<String,Object> deleterunner(Long orderId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(orderService.deleteorderByorderId(orderId)>0){
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
    @RequestMapping("/batchdeleteorder")
    @ResponseBody
    public Map<String,Object> batchdeleteorder(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(orderService.deleteorderByorderIds(ids)>0){
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

    @RequestMapping("/updateorder")
    @ResponseBody
    public Map<String,Object> updateorder(Order order){
        System.out.println(order);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(orderService.updateOrder(order)>0){
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

}
