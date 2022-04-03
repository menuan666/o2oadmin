package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 商品类别
 */
@Data
public class ProductCategory {
    //商品类别ID
    private Long productCategoryId;
    //店铺 ID
    private Long shopId;
    //商品类别名字
    private String productCategoryName;
    //权重
    private Integer priority;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
