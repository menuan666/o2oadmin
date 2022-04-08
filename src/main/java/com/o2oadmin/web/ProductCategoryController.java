package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.ProductCategory;
import com.o2oadmin.service.ProductCategoryService;
import com.o2oadmin.util.DataGridViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/productcategorylist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,String productCategoryName,Integer shopId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        boolean isproductCategoryName = "".equals(productCategoryName) || productCategoryName=="";
        boolean isshopId = shopId==null;
        List<ProductCategory> productCategoryList = null;
        ProductCategory productCategory = new ProductCategory();
        if (!isproductCategoryName){
            productCategory.setProductCategoryName(productCategoryName);
            productCategoryList = productCategoryService.selectProductCategoryList(productCategory);
        }
        if (!isshopId){
            productCategory.setShopId(Long.valueOf(shopId));
            productCategoryList = productCategoryService.selectProductCategoryList(productCategory);
        }
        productCategoryList = productCategoryService.selectProductCategoryList(productCategory);
        //创建分页对象
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(productCategoryList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updateproductcategory")
    @ResponseBody
    public Map<String,Object> updatearea(ProductCategory ProductCategory){
        System.out.println(ProductCategory);
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(ProductCategory);
        try {
            if(productCategoryService.updateProductCategory(ProductCategory)>0){
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
    @RequestMapping("/deleteproductcategory")
    @ResponseBody
    public Map<String,Object> deletearea(Long productCategoryId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(productCategoryService.deleteProductCategoryByProductCategoryId(productCategoryId)>0){
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
    @RequestMapping("/batchdeleteproductcategory")
    @ResponseBody
    public Map<String,Object> batchdeletearea(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(productCategoryService.deleteProductCategoryByProductCategoryIds(ids)>0){
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
