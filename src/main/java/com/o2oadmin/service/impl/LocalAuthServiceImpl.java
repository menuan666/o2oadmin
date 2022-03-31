package com.o2oadmin.service.impl;

import com.o2oadmin.dao.LocalAuthDao;
import com.o2oadmin.entity.LocalAuth;
import com.o2oadmin.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalAuthServiceImpl implements LocalAuthService {
    @Autowired
    private LocalAuthDao localAuthDao;

    /**
     * 查询用户账号管理
     *
     * @param localAuthId 用户账号管理主键
     * @return 用户账号管理
     */
    @Override
    public LocalAuth selectLocalAuthByLocalAuthId(Long localAuthId)
    {
        return localAuthDao.selectLocalAuthByLocalAuthId(localAuthId);
    }

    /**
     * 查询用户账号管理列表
     *
     * @param LocalAuth 用户账号管理
     * @return 用户账号管理
     */
    @Override
    public List<LocalAuth> selectLocalAuthList(LocalAuth LocalAuth)
    {
        return localAuthDao.selectLocalAuthList(LocalAuth);
    }

    /**
     * 修改用户账号管理
     *
     * @param LocalAuth 用户账号管理
     * @return 结果
     */
    @Override
    public int updateLocalAuth(LocalAuth LocalAuth)
    {
        return localAuthDao.updateLocalAuth(LocalAuth);
    }
}
