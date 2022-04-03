package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    //订单编号
    private Long orderId;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //价格
    private double price;
    //取货码
    private String code;
    //商品名
    private int orderType;
    //商品名
    private String productName;
    //是否完成 0未完成 1已完成
    private Integer status;
    //个人信息
    private Long userId;
}
