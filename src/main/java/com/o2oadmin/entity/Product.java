package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    //商品ID
    private Long productId;
    //商品名字
    private String productName;
    //描述
    private String productDesc;
    //简略图地址
    private String imgAddr;
    //原价
    private String normalPrice;
    //折扣价
    private String promotionPrice;
    //权重
    private Integer priority;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //最后更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
    //-1.不可用，0.下架 1.在前端展示系统展示
    private Integer enableStatus;
    //商品详情图片列表
    private List<Long> productImgId;
    //商品类别
    private Long productCategoryId;
    //店铺
    private Long shopId;

}
