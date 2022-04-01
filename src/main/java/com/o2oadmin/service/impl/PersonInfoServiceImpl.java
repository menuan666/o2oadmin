package com.o2oadmin.service.impl;

import com.o2oadmin.dao.PersonInfoDao;
import com.o2oadmin.entity.PersonInfo;
import com.o2oadmin.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;

    /**
     * 查询用户信息管理
     *
     * @param userId 用户信息管理主键
     * @return 用户信息管理
     */
    @Override
    public PersonInfo selectPersonInfoByUserId(Long userId)
    {
        return personInfoDao.selectPersonInfoByUserId(userId);
    }

    /**
     * 查询用户信息管理列表
     *
     * @param PersonInfo 用户信息管理
     * @return 用户信息管理
     */
    @Override
    public List<PersonInfo> selectPersonInfoList(PersonInfo PersonInfo)
    {
        return personInfoDao.selectPersonInfoList(PersonInfo);
    }


    /**
     * 修改用户信息管理
     *
     * @param PersonInfo 用户信息管理
     * @return 结果
     */
    @Override
    public int updatePersonInfo(PersonInfo PersonInfo)
    {
        return personInfoDao.updatePersonInfo(PersonInfo);
    }

    /**
     * 批量删除用户信息管理
     *
     * @param userIds 需要删除的用户信息管理主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByUserIds(String userIds)
    {
        String[] str = userIds.split(",");
        System.out.println(Arrays.toString(str));
        return personInfoDao.deletePersonInfoByUserIds(str);
    }

    /**
     * 删除用户信息管理信息
     *
     * @param userId 用户信息管理主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByUserId(Long userId)
    {
        return personInfoDao.deletePersonInfoByUserId(userId);
    }

}
