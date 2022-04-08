package com.o2oadmin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.o2oadmin.entity.HeadLine;
import com.o2oadmin.service.HeadLineService;
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
@RequestMapping("/headline")
public class HeadLineController {
    @Autowired
    private HeadLineService headLineService;

    @RequestMapping(value = "/headlinelist",method = RequestMethod.GET)
    @ResponseBody
    public DataGridViewResult list(int page, int limit, String lineName, Integer enableStatus) {
        //System.out.println("page:"+page+",limit:"+limit);
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(page, limit);
        //调用分页查询列表的方法
        List<HeadLine> headLineList = null;
        HeadLine headLine = new HeadLine();
        if (!"".equals(lineName)||lineName == null){
            headLine.setLineName(lineName);
        }
        if (enableStatus!=null){
            headLine.setEnableStatus(enableStatus);
        }
        System.out.println(headLine);
        headLineList = headLineService.selectHeadLineList(headLine);
        //创建分页对象
        PageInfo<HeadLine> pageInfo = new PageInfo<HeadLine>(headLineList);
        //返回数据
        DataGridViewResult data = new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
        return data;
    }


    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyPersonInfo(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String,Object>();
        CommonsMultipartFile imgline = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        imgline = (CommonsMultipartFile) multipartHttpServletRequest.getFile("imgline");
            ImageHolder imageHolder = null;
            if (imgline != null) {
                try {
                    imageHolder = new ImageHolder(imgline.getOriginalFilename(), imgline.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String dest = PathUtil.getlineImagePath();
                String thumbnailAddr = ImageUtil.generateThumbnailheadline(imageHolder, dest);
                map.put("success", true);
                map.put("src",thumbnailAddr);
            }else {
                map.put("success", false);
                map.put("src","");
                map.put("message", "图片上传失败");
            }
        return map;
        }


    @RequestMapping("/addheadline")
    @ResponseBody
    public Map<String,Object> addarea(HeadLine headLine,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();

        headLine.setCreateTime(new Date());
        if(headLineService.insertHeadLine(headLine)>0){
            map.put("success",true);
            map.put("message","添加成功");
        }else{
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }
    @RequestMapping("/updateheadline")
    @ResponseBody
    public Map<String,Object> updatearea(HeadLine headLine){
        System.out.println(headLine);

        Map<String,Object> map = new HashMap<String,Object>();
        headLine.setLastEditTime(new Date());
        System.out.println("修改"+headLine);
        try {
            if(headLineService.updateHeadLine(headLine)>0){
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
    @RequestMapping("/deleteheadline")
    @ResponseBody
    public Map<String,Object> deletearea(Long lineId){
        //System.out.println(areaId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(headLineService.deleteHeadLineByLineId(lineId)>0){
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
}
