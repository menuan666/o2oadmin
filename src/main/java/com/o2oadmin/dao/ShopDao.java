package com.o2oadmin.dao;

import com.o2oadmin.entity.Shop;

import java.util.List;

public interface ShopDao {
    /**
     * 查询店铺信息管理
     *
     * @param shopId 店铺信息管理主键
     * @return 店铺信息管理
     */
    public Shop selectShopByShopId(Long shopId);

    /**
     * 查询店铺信息管理列表
     *
     * @param Shop 店铺信息管理
     * @return 店铺信息管理集合
     */
    public List<Shop> selectShopList(Shop Shop);

    /**
     * 新增店铺信息管理
     *
     * @param Shop 店铺信息管理
     * @return 结果
     */
    public int insertShop(Shop Shop);

    /**
     * 修改店铺信息管理
     *
     * @param Shop 店铺信息管理
     * @return 结果
     */
    public int updateShop(Shop Shop);

    /**
     * 删除店铺信息管理
     *
     * @param shopId 店铺信息管理主键
     * @return 结果
     */
    public int deleteShopByShopId(Long shopId);

    /**
     * 批量删除店铺信息管理
     *
     * @param shopIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopByShopIds(String[] shopIds);
}
