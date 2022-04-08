package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 店铺类别
 */
@Data
public class ShopCategory {
    //ID
    private Long shopCategoryId;
    //店铺名字
    private String shopCategoryName;
    //店铺描述
    private String shopCategoryDesc;
    //店铺图片
    private String shopCategoryImg;
    //权重
    private Integer priority;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //最后修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
    //上级ID
    private Long parentId;

}
