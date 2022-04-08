package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.ProductImg;
import com.o2oadmin.service.ProductImgService;
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
@RequestMapping("/productimg")
public class ProductImgController {
    @Autowired
    private ProductImgService productImgService;

    @RequestMapping(value = "/productimglist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page,int limit,Integer productId) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        List<ProductImg> productImgList = null;
        ProductImg pr = new ProductImg();
        if (productId == null){
            productImgList = productImgService.selectProductImgList(pr);
        }else{
            pr.setProductId(Long.valueOf(productId));
            productImgList = productImgService.selectProductImgList(pr);
        }
        //创建分页对象
        PageInfo<ProductImg> pageInfo = new PageInfo<ProductImg>(productImgList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }

    @RequestMapping("/deleteproductimg")
    @ResponseBody
    public Map<String,Object> deletearea(Long productImgId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(productImgService.deleteProductImgByProductImgId(productImgId)>0){
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
    @RequestMapping("/batchdeleteproductimg")
    @ResponseBody
    public Map<String,Object> batchdeletearea(String ids){
        //ids = "( "+ids+" )";
        System.out.println(ids);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(productImgService.deleteProductImgByProductImgIds(ids)>0){
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
