package com.o2oadmin.service;

import com.o2oadmin.entity.LocalAuth;

import java.util.List;

public interface LocalAuthService {
    /**
     * 查询用户账号管理
     *
     * @param localAuthId 用户账号管理主键
     * @return 用户账号管理
     */
    public LocalAuth selectLocalAuthByLocalAuthId(Long localAuthId);

    /**
     * 查询用户账号管理列表
     *
     * @param LocalAuth 用户账号管理
     * @return 用户账号管理集合
     */
    public List<LocalAuth> selectLocalAuthList(LocalAuth LocalAuth);

    /**
     * 修改用户账号管理
     *
     * @param LocalAuth 用户账号管理
     * @return 结果
     */
    public int updateLocalAuth(LocalAuth LocalAuth);
}
