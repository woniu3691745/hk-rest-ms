package com.team.hk.orderInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.orderInfo.entity.OrderDishInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴信息mapper接口
 */
public interface OrderDishInfoMapper extends CommonMapper<OrderDishInfo> {

    /**
     * 伴随订单删除全部
     *
     * @param orderId 订单ID
     * @return rowsAffected
     */
    int deleteByIdsForOrder(List<Long> orderId);

    /**
     * 删除多条
     *
     * @param id 订单_菜肴ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);

    /**
     * 增加
     *
     * @param orderDishInfo 实体
     */
    int add(List<OrderDishInfo> orderDishInfo);
}
