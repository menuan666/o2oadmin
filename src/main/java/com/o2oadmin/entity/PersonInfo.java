package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 个人信息
 */
@Data
public class PersonInfo {
    //ID
    private Long userId;
    //姓名昵称
    private String name;
    //头像
    private String profileImg;
    //邮箱
    private String email;
    //性别
    private String gender;
    //用户余额
    private double balance;
    //用户状态
    private Integer enableStatus;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    // 最后更改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
}
