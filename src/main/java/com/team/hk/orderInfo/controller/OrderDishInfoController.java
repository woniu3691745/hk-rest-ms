package com.team.hk.orderInfo.controller;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴信息接口
 */
public interface OrderDishInfoController {

    /**
     * 获得订单信息
     *
     * @return List<OrderDishInfo>
     */
    List<OrderDishInfo> getAllOrderDishInfo(Long id);

    /**
     * 增加订单中的菜肴
     *
     * @param orderDishInfo 订单_菜肴实体
     * @return rowsAffected
     */
    int addOrderDishInfo(List<OrderDishInfo> orderDishInfo);

    /**
     * 修改订单
     *
     * @param orderDishInfo 订单_菜肴实体
     * @return rowsAffected
     */
    int updateOrderDishInfo(OrderDishInfo orderDishInfo);

    /**
     * 删除一个订单
     *
     * @param id 订单_菜肴实体ID
     * @return rowsAffected
     */
    int deleteOrderDishInfoById(Long id);

    /**
     * 删除多个订单
     *
     * @param id 订单_菜肴实体ID
     * @return rowsAffected
     */
    int deleteOrderDishInfoByIds(List<Long> id);
}
