package com.team.hk.orderInfo.service.impl;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.mapper.OrderDishInfoMapper;
import com.team.hk.orderInfo.service.OrderDishInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴信息Service实现类
 */
@Transactional
@Service
public class OrderDishInfoServiceImpl implements OrderDishInfoService {

    private static Logger logger = Logger.getLogger(OrderDishInfoServiceImpl.class);

    @Autowired
    private OrderDishInfoMapper orderDishInfoMapper;

    @Override
    public List<OrderDishInfo> getAllOrderDishInfoService(Long id) {
        return orderDishInfoMapper.list(id);
    }

    @Override
    public int addOrderDishInfoService(List<OrderDishInfo> orderDishInfo) {
        return orderDishInfoMapper.add(orderDishInfo);
    }

    @Override
    public int updateOrderDishInfo(OrderDishInfo orderDishInfo) {
        return orderDishInfoMapper.update(orderDishInfo);
    }

    @Override
    public int deleteOrderDishInfoByIdService(Long id) {
        return orderDishInfoMapper.deleteById(id);
    }

    @Override
    public int deleteOrderDishInfoByIdsService(List<Long> id) {
        return orderDishInfoMapper.deleteByIds(id);
    }

}
