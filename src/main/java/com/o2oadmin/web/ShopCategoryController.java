package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.HeadLine;
import com.o2oadmin.entity.ShopCategory;
import com.o2oadmin.service.HeadLineService;
import com.o2oadmin.service.ShopCategoryService;
import com.o2oadmin.util.DataGridViewResult;
import com.o2oadmin.util.ImageHolder;
import com.o2oadmin.util.ImageUtil;
import com.o2oadmin.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopcategory")
public class ShopCategoryController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @RequestMapping(value = "/shopcategorylist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page, int limit, String shopCategoryName, Integer parentId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        List<ShopCategory> shopCategoryList = null;
        ShopCategory shopCategory = new ShopCategory();
        if (!"".equals(shopCategoryName)||shopCategoryName == null){
            shopCategory.setShopCategoryName(shopCategoryName);
        }
        if (parentId!=null){
            shopCategory.setParentId(Long.valueOf(parentId));
        }
        System.out.println(shopCategory);
        shopCategoryList = shopCategoryService.selectShopCategoryList(shopCategory);
        //创建分页对象
        PageInfo<ShopCategory> pageInfo = new PageInfo<ShopCategory>(shopCategoryList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }


    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyPersonInfo(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String,Object>();
        CommonsMultipartFile imgshopcate = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        imgshopcate = (CommonsMultipartFile) multipartHttpServletRequest.getFile("imgshopcate");
            ImageHolder imageHolder = null;
            if (imgshopcate != null) {
                try {
                    imageHolder = new ImageHolder(imgshopcate.getOriginalFilename(), imgshopcate.getInputStream());
                } catch (IOException e) {
                    map.put("success", false);
                    map.put("message", "存储图片异常");
                    return map;
                }
                String dest = PathUtil.getlineImagePath();
                String thumbnailAddr = ImageUtil.generateThumbnailshopcate(imageHolder, dest);
                map.put("src",thumbnailAddr);
            }else {
                map.put("src",null);
                map.put("message", "无图片");
            }
        map.put("success", true);
        return map;
        }


    @RequestMapping("/addshopcategory")
    @ResponseBody
    public Map<String,Object> addarea(ShopCategory shopCategory){
        Map<String,Object> map = new HashMap<String,Object>();
        shopCategory.setCreateTime(new Date());
        if(shopCategoryService.insertShopCategory(shopCategory)>0){
            map.put("success",true);
            map.put("message","添加成功");
        }else{
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }
    @RequestMapping("/updateshopcategory")
    @ResponseBody
    public Map<String,Object> updatearea(ShopCategory shopCategory){
        System.out.println(shopCategory);
        Map<String,Object> map = new HashMap<String,Object>();
        shopCategory.setLastEditTime(new Date());
        System.out.println("修改"+shopCategory);
        try {
            if(shopCategoryService.updateShopCategory(shopCategory)>0){
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
    @RequestMapping("/deleteshopcategory")
    @ResponseBody
    public Map<String,Object> deletearea(Long shopCategoryId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(shopCategoryService.deleteShopCategoryByShopCategoryId(shopCategoryId)>0){
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
    @RequestMapping("/batchdeleteshopcategory")
    @ResponseBody
    public Map<String,Object> batchdeleteorder(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(shopCategoryService.deleteShopCategoryByShopCategoryIds(ids)>0){
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
