package com.o2oadmin.service.impl;

import com.o2oadmin.dao.ShopCategoryDao;
import com.o2oadmin.entity.ShopCategory;
import com.o2oadmin.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    /**
     * 查询商铺类别信息管理
     *
     * @param shopCategoryId 商铺类别信息管理主键
     * @return 商铺类别信息管理
     */
    @Override
    public ShopCategory selectShopCategoryByShopCategoryId(Long shopCategoryId)
    {
        return shopCategoryDao.selectShopCategoryByShopCategoryId(shopCategoryId);
    }

    /**
     * 查询商铺类别信息管理列表
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 商铺类别信息管理
     */
    @Override
    public List<ShopCategory> selectShopCategoryList(ShopCategory ShopCategory)
    {
        return shopCategoryDao.selectShopCategoryList(ShopCategory);
    }

    /**
     * 新增商铺类别信息管理
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 结果
     */
    @Override
    public int insertShopCategory(ShopCategory ShopCategory)
    {
        return shopCategoryDao.insertShopCategory(ShopCategory);
    }

    /**
     * 修改商铺类别信息管理
     *
     * @param ShopCategory 商铺类别信息管理
     * @return 结果
     */
    @Override
    public int updateShopCategory(ShopCategory ShopCategory)
    {
        return shopCategoryDao.updateShopCategory(ShopCategory);
    }

    /**
     * 批量删除商铺类别信息管理
     *
     * @param shopCategoryIds 需要删除的商铺类别信息管理主键
     * @return 结果
     */
    @Override
    public int deleteShopCategoryByShopCategoryIds(String shopCategoryIds)
    {
        String[] str = shopCategoryIds.split(",");
        return shopCategoryDao.deleteShopCategoryByShopCategoryIds(str);
    }

    /**
     * 删除商铺类别信息管理信息
     *
     * @param shopCategoryId 商铺类别信息管理主键
     * @return 结果
     */
    @Override
    public int deleteShopCategoryByShopCategoryId(Long shopCategoryId)
    {
        return shopCategoryDao.deleteShopCategoryByShopCategoryId(shopCategoryId);
    }
}
