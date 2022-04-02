package com.o2oadmin.service.impl;

import com.o2oadmin.dao.PersonInfoDao;
import com.o2oadmin.entity.PersonInfo;
import com.o2oadmin.service.LocalAuthService;
import com.o2oadmin.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;
    @Autowired
    private LocalAuthService localAuthService;
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
    @Transactional(rollbackFor = Exception.class)
    public int deletePersonInfoByUserIds(String userIds)
    {
        String[] str = userIds.split(",");
        System.out.println(Arrays.toString(str));
        int i = 0;
        try{
            if(localAuthService.deleteLocalAuthByUserIds(userIds)>0){
                i = personInfoDao.deletePersonInfoByUserIds(str);
            }
        }catch(Exception e) {
            throw new RuntimeException();
        }
        return i;
    }

    /**
     * 删除用户信息管理信息
     *
     * @param userId 用户信息管理主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePersonInfoByUserId(Long userId) {
        int i = 0;
        try{
            if(localAuthService.deleteLocalAuthByUserId(userId)>0){
                i = personInfoDao.deletePersonInfoByUserId(userId);
            }
        }catch(Exception e) {
            throw new RuntimeException();
        }
        return i;
    }
}
