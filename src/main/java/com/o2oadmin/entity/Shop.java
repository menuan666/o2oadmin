package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 店铺
 */
@Data

public class Shop {
    //ID
    private Long shopId;
    //店铺名字
    private String shopName;
    //店铺描述
    private String shopDesc;
    //店铺地址
    private String shopAddr;
    //联系方式
    private String phone;
    //店铺图片
    private String shopImg;
    //权重
    private Integer priority;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //最后修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
    //-1.不可用 0.审核中 1.可用
    private Integer enableStatus;
    //超级管理员给店家的提醒
    private String advice;
    //区域
    private Long areaId;
    //用户信息
    private Long ownerId;
    //店铺类别
    private Long shopCategoryId;
}
