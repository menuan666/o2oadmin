package com.o2oadmin.service.impl;

import com.o2oadmin.dao.ProductCategoryDao;
import com.o2oadmin.entity.ProductCategory;
import com.o2oadmin.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 查询商品类别信息管理
     *
     * @param productCategoryId 商品类别信息管理主键
     * @return 商品类别信息管理
     */
    @Override
    public ProductCategory selectProductCategoryByProductCategoryId(Long productCategoryId)
    {
        return productCategoryDao.selectProductCategoryByProductCategoryId(productCategoryId);
    }

    /**
     * 查询商品类别信息管理列表
     *
     * @param ProductCategory 商品类别信息管理
     * @return 商品类别信息管理
     */
    @Override
    public List<ProductCategory> selectProductCategoryList(ProductCategory ProductCategory)
    {
        return productCategoryDao.selectProductCategoryList(ProductCategory);
    }

    /**
     * 修改商品类别信息管理
     *
     * @param ProductCategory 商品类别信息管理
     * @return 结果
     */
    @Override
    public int updateProductCategory(ProductCategory ProductCategory)
    {
        return productCategoryDao.updateProductCategory(ProductCategory);
    }

    /**
     * 批量删除商品类别信息管理
     *
     * @param productCategoryIds 需要删除的商品类别信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByProductCategoryIds(String productCategoryIds)
    {
        String[] str = productCategoryIds.split(",");
        System.out.println(Arrays.toString(str));
        return productCategoryDao.deleteProductCategoryByProductCategoryIds(str);
    }

    /**
     * 删除商品类别信息管理信息
     *
     * @param productCategoryId 商品类别信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByProductCategoryId(Long productCategoryId)
    {
        return productCategoryDao.deleteProductCategoryByProductCategoryId(productCategoryId);
    }
}
