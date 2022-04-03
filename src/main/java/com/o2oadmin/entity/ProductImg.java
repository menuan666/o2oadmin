package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 图片描述
 */
@Data
public class ProductImg {
    //图片ID
    private Long productImgId;
    //图片地址
    private String imgAddr;
    //图片描述
    private String imgDesc;
    //权重
    private Integer priority;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //商品ID
    private Long productId;

}
