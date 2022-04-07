package com.o2oadmin.service.impl;

import com.o2oadmin.dao.ProductDao;
import com.o2oadmin.entity.Product;
import com.o2oadmin.service.ProductImgService;
import com.o2oadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgService productImgService;

    /**
     * 查询商品信息管理
     *
     * @param productId 商品信息管理主键
     * @return 商品信息管理
     */
    @Override
    public Product selectProductByProductId(Long productId)
    {
        return productDao.selectProductByProductId(productId);
    }

    /**
     * 查询商品信息管理列表
     *
     * @param Product 商品信息管理
     * @return 商品信息管理
     */
    @Override
    public List<Product> selectProductList(Product Product)
    {
        return productDao.selectProductList(Product);
    }


    /**
     * 修改商品信息管理
     *
     * @param Product 商品信息管理
     * @return 结果
     */
    @Override
    public int updateProduct(Product Product)
    {
        return productDao.updateProduct(Product);
    }

    /**
     * 批量删除商品信息管理
     *
     * @param productIds 需要删除的商品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductIds(String productIds)
    {
        String[] str = productIds.split(",");
        System.out.println(Arrays.toString(str));
        return productDao.deleteProductByProductIds(str);
    }

    /**
     * 删除商品信息管理信息
     *
     * @param productId 商品信息管理主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteProductByProductId(Long productId)
    {
        if (productImgService.deleteProductImgByProductId(productId)>0){
            return productDao.deleteProductByProductId(productId);
        }else {
            return 0;
        }
    }
}
