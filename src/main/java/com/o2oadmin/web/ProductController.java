package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.PersonInfo;
import com.o2oadmin.entity.Product;
import com.o2oadmin.service.LocalAuthService;
import com.o2oadmin.service.PersonInfoService;
import com.o2oadmin.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/productlist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,String productName,
                                   Integer productCategoryId, Integer shopId,Integer enableStatus) {
        System.out.println("page:"+page+",limit:"+limit+",productName:"+productName+",productCategoryId:"+productCategoryId+",shopId:"+shopId+",enableStatus:"+enableStatus);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        boolean isname = "".equals(productName)||productName == null;
        boolean isemail = productCategoryId == null;
        boolean isgender = shopId == null;
        boolean isenableStatus= enableStatus==null;
        Product product = new Product();
        if(!isname){
            product.setProductName(productName);
        }
        if(!isemail){
            product.setProductCategoryId(Long.valueOf(productCategoryId));
        }
        if(!isgender){
            product.setShopId(Long.valueOf(shopId));
        }
        if(!isenableStatus){
            product.setEnableStatus(enableStatus);
        }
        //List<LocalAuth> localauthList = null;
        List<Product> productList = productService.selectProductList(product);
        //创建分页对象
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/updateproduct")
    @ResponseBody
    public Map<String,Object> updatearea(Product Product){
        System.out.println(Product);
        Map<String,Object> map = new HashMap<String,Object>();
        Product.setLastEditTime(new Date());
        System.out.println(Product);
        //personInfo.setPassword(MD5.getMd5(localAuth.getPassword()));
        try {
        if(productService.updateProduct(Product)>0){
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
    @RequestMapping("/deleteproduct")
    @ResponseBody
    public Map<String,Object> deletepersoninfo(Long productId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(productService.deleteProductByProductId(productId)>0){
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
    @RequestMapping("/batchdeleteproduct")
    @ResponseBody
    public Map<String,Object> batchdeletepersoninfo(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(productService.deleteProductByProductIds(ids)>0){
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
