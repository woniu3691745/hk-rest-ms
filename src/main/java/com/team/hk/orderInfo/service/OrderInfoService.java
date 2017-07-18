package com.team.hk.orderInfo.service;

import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单信息Service接口
 */
public interface OrderInfoService {

    /**
     * 获得订单信息（通过分页)
     *
     * @return List<OrderInfo>
     */
    List<OrderInfo> getAllOrderInfoByPageService(OrderInfo orderInfo, Long pageNo, Long pageSize);

    /**
     * 获得订单信息数量
     *
     * @return List<OrderInfo>
     */
    int getAllOrderInfoCountByPageService(OrderInfo orderInfo, Long pageNo, Long pageSize);

    /**
     * 获得订单信息
     *
     * @return List<OrderInfo>
     */
    List<OrderInfo> getAllOrderInfoService(OrderInfo orderInfo);

    /**
     * 增加订单信息
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    int addOrderInfoService(OrderInfo orderInfo, List<OrderDishInfo> orderDishInfo);

    /**
     * 修改订单信息
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    int updateOrderInfoService(OrderInfo orderInfo);

    /**
     * 删除一条订单信息
     *
     * @param id 订单ID
     * @return rowsAffected
     */
    int deleteOrderInfoByIdService(Long id);

    /**
     * 删除多条订单信息
     *
     * @param id 订单ID
     * @return rowsAffected
     */
    int deleteOrderInfoByIdsService(List<Long> id);
}
