package com.team.hk.orderInfo.service;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴信息Service接口
 */
public interface OrderDishInfoService {

    /**
     * 获得订单_菜肴信息
     *
     * @return List<OrderDishInfo>
     */
    List<OrderDishInfo> getAllOrderDishInfoService(Long id);

    /**
     * 增加订单_菜肴信息
     *
     * @param orderDishInfo 订单_菜肴实体
     * @return 条数
     */
    int addOrderDishInfoService(List<OrderDishInfo> orderDishInfo);

    /**
     * 修改订单_菜肴信息
     *
     * @param orderDishInfo 订单_菜肴实体
     * @return 条数
     */
    int updateOrderDishInfo(OrderDishInfo orderDishInfo);

    /**
     * 删除一条订单_菜肴信息
     *
     * @param id 订单_菜肴ID
     * @return 条数
     */
    int deleteOrderDishInfoByIdService(Long id);

    /**
     * 删除多条订单_菜肴信息
     *
     * @param id 订单_菜肴ID
     * @return 条数
     */
    int deleteOrderDishInfoByIdsService(List<Long> id);
}
