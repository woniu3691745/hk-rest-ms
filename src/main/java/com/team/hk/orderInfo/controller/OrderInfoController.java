package com.team.hk.orderInfo.controller;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.entity.OrderToDishInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单信息接口
 */
public interface OrderInfoController {

    /**
     * 获得订单信息（通过分页）
     *
     * @param orderInfo 订单实体
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<OrderInfo>
     */
    List<OrderInfo> getAllOrderInfoByPage(OrderInfo orderInfo, Long pageNo, Long pageSize);

    /**
     * 获得订单信息
     *
     * @param orderInfo 订单实体
     * @return List<OrderInfo>
     */
    List<OrderInfo> getAllOrderInfo(OrderInfo orderInfo);

    /**
     * 增加订单
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    int addOrderInfo(OrderInfo orderInfo, List<OrderDishInfo> orderDishInfo);

    /**
     * 修改订单
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 删除一个订单
     *
     * @param id 订单ID
     * @return rowsAffected
     */
    int deleteOrderInfoById(Long id);

    /**
     * 删除多个订单
     *
     * @param id 订单ID
     * @return rowsAffected
     */
    int deleteOrderInfoByIds(List<Long> id);

    /**
     * 获得订单信息
     *
     * @param orderToDishInfo 订单对订单_菜肴实体类
     * @return List<OrderToDishInfo>
     */
    List<OrderToDishInfo> listOrderToDish(OrderToDishInfo orderToDishInfo);
}

