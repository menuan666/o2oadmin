package com.o2oadmin.dao;

import com.o2oadmin.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryDao {
    /**
     * 查询商铺类别信息管理
     *
     * @param shopCategoryId 商铺类别信息管理主键
     * @return 商铺类别信息管理
     */
    public ShopCategory selectShopCategoryByShopCategoryId(Long shopCategoryId);

    /**
     * 查询商铺类别信息管理列表
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 商铺类别信息管理集合
     */
    public List<ShopCategory> selectShopCategoryList(ShopCategory ShopCategory);

    /**
     * 新增商铺类别信息管理
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 结果
     */
    public int insertShopCategory(ShopCategory ShopCategory);

    /**
     * 修改商铺类别信息管理
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 结果
     */
    public int updateShopCategory(ShopCategory ShopCategory);

    /**
     * 删除商铺类别信息管理
     *
     * @param shopCategoryId 商铺类别信息管理主键
     * @return 结果
     */
    public int deleteShopCategoryByShopCategoryId(Long shopCategoryId);

    /**
     * 批量删除商铺类别信息管理
     *
     * @param shopCategoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopCategoryByShopCategoryIds(String[] shopCategoryIds);
}
