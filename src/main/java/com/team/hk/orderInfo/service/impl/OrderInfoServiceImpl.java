package com.team.hk.orderInfo.service.impl;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.mapper.OrderDishInfoMapper;
import com.team.hk.orderInfo.mapper.OrderInfoMapper;
import com.team.hk.orderInfo.service.OrderInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单信息Service实现类
 */
@Transactional
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private static Logger logger = Logger.getLogger(OrderInfoServiceImpl.class);

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderDishInfoMapper orderDishInfoMapper;

    @Override
    public List<OrderInfo> getAllOrderInfoByPageService(OrderInfo orderInfo, Long pageNo, Long pageSize) {
        orderInfo.setPageNo(pageNo);
        orderInfo.setPageSize(pageSize);
        return orderInfoMapper.listByPage(orderInfo);
    }

    @Override
    public int getAllOrderInfoCountByPageService(OrderInfo orderInfo, Long pageNo, Long pageSize) {
        orderInfo.setPageNo(pageNo);
        orderInfo.setPageSize(pageSize);
        return orderInfoMapper.listCountByPage(orderInfo);
    }

    @Override
    public List<OrderInfo> getAllOrderInfoService(OrderInfo orderInfo) {
        return orderInfoMapper.list(orderInfo);
    }

    /**
     * 获取订单ID，保存到订单菜肴表里，关联起来
     *
     * @param orderInfo     订单实体
     * @param orderDishInfo 订单菜肴实体
     * @return 记录条数
     */
    @Override
    public int addOrderInfoService(OrderInfo orderInfo, List<OrderDishInfo> orderDishInfo) {
        orderInfoMapper.add(orderInfo);
        orderDishInfo.forEach(o -> o.setOrderId(orderInfo.getOrderId()));
        return orderDishInfoMapper.add(orderDishInfo);
    }

    @Override
    public int updateOrderInfoService(OrderInfo orderInfo) {
        return orderInfoMapper.update(orderInfo);
    }

    /**
     * 删除订单信息
     * 删除菜肴信息
     *
     * @param orderId 订单ID
     * @return rowsAffected
     */
    @Override
    public int deleteOrderInfoByIdService(Long orderId) {
        List<Long> longs = new ArrayList<>();
        longs.add(orderId);
        int i = orderInfoMapper.deleteById(orderId);
        orderDishInfoMapper.deleteByIdsForOrder(longs);
        return i;
    }

    /**
     * 删除订单信息
     * 删除菜肴信息
     *
     * @param orderId 订单ID
     * @return rowsAffected
     */
    @Override
    public int deleteOrderInfoByIdsService(List<Long> orderId) {
        int i = orderInfoMapper.deleteByIds(orderId);
        orderDishInfoMapper.deleteByIdsForOrder(orderId);
        return i;
    }

}
