package com.o2oadmin.dao;

import com.o2oadmin.entity.LocalAuth;
import com.o2oadmin.entity.PersonInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author menuan
 * 本地账号
 */

public interface LocalAuthDao {
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
    /**
     * 删除用户账号管理
     *
     * @param userId 用户账号管理主键
     * @return 结果
     */
    public int deleteLocalAuthByUserId(Long userId);

    /**
     * 批量删除用户账号管理
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLocalAuthByUserIds(String[] userIds);
}
