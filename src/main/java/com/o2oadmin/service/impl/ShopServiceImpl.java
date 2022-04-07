package com.o2oadmin.service.impl;

import com.o2oadmin.dao.ShopDao;
import com.o2oadmin.entity.Shop;
import com.o2oadmin.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    /**
     * 查询店铺信息管理
     *
     * @param shopId 店铺信息管理主键
     * @return 店铺信息管理
     */
    @Override
    public Shop selectShopByShopId(Long shopId)
    {
        return shopDao.selectShopByShopId(shopId);
    }

    /**
     * 查询店铺信息管理列表
     *
     * @param Shop 店铺信息管理
     * @return 店铺信息管理
     */
    @Override
    public List<Shop> selectShopList(Shop Shop)
    {
        return shopDao.selectShopList(Shop);
    }

    /**
     * 新增店铺信息管理
     *
     * @param Shop 店铺信息管理
     * @return 结果
     */
    @Override
    public int insertShop(Shop Shop)
    {
        return shopDao.insertShop(Shop);
    }

    /**
     * 修改店铺信息管理
     *
     * @param Shop 店铺信息管理
     * @return 结果
     */
    @Override
    public int updateShop(Shop Shop)
    {
        return shopDao.updateShop(Shop);
    }

    /**
     * 批量删除店铺信息管理
     *
     * @param shopIds 需要删除的店铺信息管理主键
     * @return 结果
     */
    @Override
    public int deleteShopByShopIds(String shopIds)
    {
        String[] str = shopIds.split(",");
        System.out.println(Arrays.toString(str));
        return shopDao.deleteShopByShopIds(str);
    }

    /**
     * 删除店铺信息管理信息
     *
     * @param shopId 店铺信息管理主键
     * @return 结果
     */
    @Override
    public int deleteShopByShopId(Long shopId)
    {
        return shopDao.deleteShopByShopId(shopId);
    }
}
