package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.Area;
import com.o2oadmin.entity.Runner;
import com.o2oadmin.entity.Shop;
import com.o2oadmin.service.ShopService;
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
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page, int limit, String shopName,Integer enableStatus,
                                   Integer areaId,Integer ownerId,Integer shopCategoryId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //System.out.println(runner);
        //调用分页查询列表的方法
        List<Area> areaList = null;
        boolean isshopName = "".equals(shopName)||shopName == null;
        boolean isenableStatus = enableStatus == null;
        boolean isareaId = areaId == null;
        boolean isownerId= ownerId==null;
        boolean isshopCategoryId= shopCategoryId==null;
        Shop shop = new Shop();
        if(!isshopName){
            shop.setShopName(shopName);
        }
        if(!isenableStatus){
            shop.setEnableStatus(enableStatus);
        }
        if(!isareaId){
            shop.setAreaId(Long.valueOf(areaId));
        }
        if(!isownerId){
            shop.setOwnerId(Long.valueOf(ownerId));
        }
        if(!isshopCategoryId){
            shop.setShopCategoryId(Long.valueOf(shopCategoryId));
        }
        System.out.println(shop);
        //List<Runner> runners = null;
        List<Shop> shopList = shopService.selectShopList(shop);
        //创建分页对象
        PageInfo<Shop> pageInfo = new PageInfo<Shop>(shopList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updateshop")
    @ResponseBody
    public Map<String,Object> updaterunner(Shop shop){
        System.out.println(shop);
        Map<String,Object> map = new HashMap<String,Object>();
        shop.setLastEditTime(new Date());
        //System.out.println(area);
        try {
            if(shopService.updateShop(shop)>0){
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
    @RequestMapping("/deleteshop")
    @ResponseBody
    public Map<String,Object> deleterunner(Long shopId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(shopService.deleteShopByShopId(shopId)>0){
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
    @RequestMapping("/batchdeleteshop")
    @ResponseBody
    public Map<String,Object> batchdeleterunner(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(shopService.deleteShopByShopIds(ids)>0){
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
