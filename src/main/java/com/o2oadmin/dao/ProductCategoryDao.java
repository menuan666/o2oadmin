package com.o2oadmin.dao;

import com.o2oadmin.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 查询商品类别信息管理
     *
     * @param productCategoryId 商品类别信息管理主键
     * @return 商品类别信息管理
     */
    public ProductCategory selectProductCategoryByProductCategoryId(Long productCategoryId);

    /**
     * 查询商品类别信息管理列表
     *
     * @param ProductCategory 商品类别信息管理
     * @return 商品类别信息管理集合
     */
    public List<ProductCategory> selectProductCategoryList(ProductCategory ProductCategory);


    /**
     * 修改商品类别信息管理
     *
     * @param ProductCategory 商品类别信息管理
     * @return 结果
     */
    public int updateProductCategory(ProductCategory ProductCategory);

    /**
     * 删除商品类别信息管理
     *
     * @param productCategoryId 商品类别信息管理主键
     * @return 结果
     */
    public int deleteProductCategoryByProductCategoryId(Long productCategoryId);

    /**
     * 批量删除商品类别信息管理
     *
     * @param productCategoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductCategoryByProductCategoryIds(String[] productCategoryIds);
}
