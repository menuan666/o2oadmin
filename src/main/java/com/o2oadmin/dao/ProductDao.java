package com.o2oadmin.dao;

import com.o2oadmin.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 查询商品信息管理
     *
     * @param productId 商品信息管理主键
     * @return 商品信息管理
     */
    public Product selectProductByProductId(Long productId);

    /**
     * 查询商品信息管理列表
     *
     * @param Product 商品信息管理
     * @return 商品信息管理集合
     */
    public List<Product> selectProductList(Product Product);


    /**
     * 修改商品信息管理
     *
     * @param Product 商品信息管理
     * @return 结果
     */
    public int updateProduct(Product Product);

    /**
     * 删除商品信息管理
     *
     * @param productId 商品信息管理主键
     * @return 结果
     */
    public int deleteProductByProductId(Long productId);

    /**
     * 批量删除商品信息管理
     *
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(String[] productIds);
}
