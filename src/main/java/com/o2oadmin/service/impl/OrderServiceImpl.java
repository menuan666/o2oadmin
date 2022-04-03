package com.o2oadmin.service.impl;

import com.o2oadmin.dao.OrderDao;
import com.o2oadmin.entity.Order;
import com.o2oadmin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * 查询订单信息管理
     *
     * @param orderId 订单信息管理主键
     * @return 订单信息管理
     */
    @Override
    public Order selectorderByorderId(Long orderId)
    {
        return orderDao.selectorderByorderId(orderId);
    }

    /**
     * 查询订单信息管理列表
     *
     * @param order 订单信息管理
     * @return 订单信息管理
     */
    @Override
    public List<Order> selectorderList(Order order)
    {
        return orderDao.selectorderList(order);
    }

    /**
     * 批量删除订单信息管理
     *
     * @param orderIds 需要删除的订单信息管理主键
     * @return 结果
     */
    @Override
    public int deleteorderByorderIds(String orderIds)
    {
        String[] str = orderIds.split(",");
        System.out.println(Arrays.toString(str));
        return orderDao.deleteorderByorderIds(str);
    }

    /**
     * 删除订单信息管理信息
     *
     * @param orderId 订单信息管理主键
     * @return 结果
     */
    @Override
    public int deleteorderByorderId(Long orderId)
    {
        return orderDao.deleteorderByorderId(orderId);
    }


    /**
     * 修改订单信息管理
     *
     * @param Order 订单信息管理
     * @return 结果
     */
    @Override
    public int updateOrder(Order Order)
    {
        return orderDao.updateOrder(Order);
    }
}
