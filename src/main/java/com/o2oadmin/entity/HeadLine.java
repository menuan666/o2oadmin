package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 首页轮播图
 */
@Data
public class HeadLine {
    //id
    private Long lineId;
    //名字
    private String lineName;
    //链接：指向某一个页面
    private String lineLink;
    //轮播图
    private String lineImg;
    //权重
    private Integer priority;
    //0.可用1.不可用
    private Integer enableStatus;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //最后修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
}
