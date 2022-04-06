package com.o2oadmin.service.impl;

import com.o2oadmin.dao.ProductImgDao;
import com.o2oadmin.entity.ProductImg;
import com.o2oadmin.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    private ProductImgDao productImgDao;

    /**
     * 查询商品图片信息管理
     *
     * @param productImgId 商品图片信息管理主键
     * @return 商品图片信息管理
     */
    @Override
    public ProductImg selectProductImgByProductImgId(Long productImgId)
    {
        return productImgDao.selectProductImgByProductImgId(productImgId);
    }

    /**
     * 查询商品图片信息管理列表
     *
     * @param ProductImg 商品图片信息管理
     * @return 商品图片信息管理
     */
    @Override
    public List<ProductImg> selectProductImgList(ProductImg ProductImg)
    {
        return productImgDao.selectProductImgList(ProductImg);
    }


    /**
     * 修改商品图片信息管理
     *
     * @param ProductImg 商品图片信息管理
     * @return 结果
     */
    @Override
    public int updateProductImg(ProductImg ProductImg)
    {
        return productImgDao.updateProductImg(ProductImg);
    }

    /**
     * 批量删除商品图片信息管理
     *
     * @param productImgIds 需要删除的商品图片信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductImgByProductImgIds(String productImgIds)
    {
        String[] str = productImgIds.split(",");
        System.out.println(Arrays.toString(str));
        return productImgDao.deleteProductImgByProductImgIds(str);
    }

    /**
     * 删除商品图片信息管理信息
     *
     * @param productImgId 商品图片信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductImgByProductImgId(Long productImgId)
    {
        return productImgDao.deleteProductImgByProductImgId(productImgId);
    }
}
