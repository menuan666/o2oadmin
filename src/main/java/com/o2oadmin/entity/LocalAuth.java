package com.o2oadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author menuan
 * 本地账号
 */
@Data
public class LocalAuth {
    //本地账号
    private Long localAuthId;
    //用户名
    private String username;
    //密码
    private String password;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastEditTime;
    //个人信息
    private Long userId;

}
