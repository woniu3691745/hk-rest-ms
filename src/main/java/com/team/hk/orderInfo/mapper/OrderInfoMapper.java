package com.team.hk.orderInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.entity.OrderToDishInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单信息Mapper接口
 */
public interface OrderInfoMapper extends CommonMapper<OrderInfo> {

    /**
     * 删除多条
     *
     * @param id 订单信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);

    /**
     * 增加
     *
     * @param orderDishInfo 实体
     */
    int add(List<OrderDishInfo> orderDishInfo);

    /**
     * 查询
     *
     * @param orderToDishInfo 订单对订单_菜肴实体类
     * @return List<OrderToDishInfo>
     */
    List<OrderToDishInfo> listOrderToDish(OrderToDishInfo orderToDishInfo);
}
