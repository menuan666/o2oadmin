package com.o2oadmin.dao;

import com.o2oadmin.entity.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单信息管理
     *
     * @param orderId 订单信息管理主键
     * @return 订单信息管理
     */
    public Order selectorderByorderId(Long orderId);

    /**
     * 查询订单信息管理列表
     *
     * @param order 订单信息管理
     * @return 订单信息管理集合
     */
    public List<Order> selectorderList(Order order);


    /**
     * 删除订单信息管理
     *
     * @param orderId 订单信息管理主键
     * @return 结果
     */
    public int deleteorderByorderId(Long orderId);

    /**
     * 批量删除订单信息管理
     *
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteorderByorderIds(String[] orderIds);

    /**
     * 修改订单信息管理
     *
     * @param order 订单信息管理
     * @return 结果
     */
    public int updateOrder(Order order);
}
