package com.o2oadmin.dao;

import com.o2oadmin.entity.PersonInfo;

import java.util.List;

public interface PersonInfoDao {
    /**
     * 查询用户信息管理
     *
     * @param userId 用户信息管理主键
     * @return 用户信息管理
     */
    public PersonInfo selectPersonInfoByUserId(Long userId);

    /**
     * 查询用户信息管理列表
     *
     * @param PersonInfo 用户信息管理
     * @return 用户信息管理集合
     */
    public List<PersonInfo> selectPersonInfoList(PersonInfo PersonInfo);



    /**
     * 修改用户信息管理
     *
     * @param PersonInfo 用户信息管理
     * @return 结果
     */
    public int updatePersonInfo(PersonInfo PersonInfo);

    /**
     * 删除用户信息管理
     *
     * @param userId 用户信息管理主键
     * @return 结果
     */
    public int deletePersonInfoByUserId(Long userId);

    /**
     * 批量删除用户信息管理
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonInfoByUserIds(String[] userIds);
}
