package com.o2oadmin.service;

import com.o2oadmin.entity.ProductImg;

import java.util.List;

public interface ProductImgService {
    /**
     * 查询商品图片信息管理
     *
     * @param productImgId 商品图片信息管理主键
     * @return 商品图片信息管理
     */
    public ProductImg selectProductImgByProductImgId(Long productImgId);

    /**
     * 查询商品图片信息管理列表
     *
     * @param ProductImg 商品图片信息管理
     * @return 商品图片信息管理集合
     */
    public List<ProductImg> selectProductImgList(ProductImg ProductImg);


    /**
     * 修改商品图片信息管理
     *
     * @param ProductImg 商品图片信息管理
     * @return 结果
     */
    public int updateProductImg(ProductImg ProductImg);

    /**
     * 批量删除商品图片信息管理
     *
     * @param productImgIds 需要删除的商品图片信息管理主键集合
     * @return 结果
     */
    public int deleteProductImgByProductImgIds(String productImgIds);
    /**
     * 删除商品图片信息管理通过商品ID
     * @param productId
     * @return
     */
    public int deleteProductImgByProductId(Long productId);
    /**
     * 删除商品图片信息管理信息
     *
     * @param productImgId 商品图片信息管理主键
     * @return 结果
     */
    public int deleteProductImgByProductImgId(Long productImgId);
}
