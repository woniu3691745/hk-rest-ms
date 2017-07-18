package com.team.hk.orderInfo.controller.impl;

import com.team.hk.orderInfo.controller.OrderDishInfoController;
import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.service.OrderDishInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴接口实现类
 */
@Controller
@RequestMapping("/api/orderDish")
public class OrderDishInfoControllerImpl implements OrderDishInfoController {

    private static Logger logger = Logger.getLogger(OrderDishInfoControllerImpl.class);

    @Autowired
    private OrderDishInfoService orderDishInfoService;

    /**
     * 获得订单_菜肴信息
     *
     * @param orderId 订单_菜肴ID
     * @return OrderDishInfo
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{orderId}", method = RequestMethod.GET)
    @Override
    public List<OrderDishInfo> getAllOrderDishInfo(@PathVariable("orderId") Long orderId) {
        return orderDishInfoService.getAllOrderDishInfoService(orderId);
    }

    /**
     * 增加订单_菜肴
     *
     * @param orderDishInfo 订单_菜肴ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addOrderDishInfo(@RequestBody List<OrderDishInfo> orderDishInfo) {
        return orderDishInfoService.addOrderDishInfoService(orderDishInfo);
    }


    /**
     * 修改订单_菜肴
     *
     * @param orderDishInfo 订单_菜肴实体
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateOrderDishInfo(@RequestBody OrderDishInfo orderDishInfo) {
        return orderDishInfoService.updateOrderDishInfo(orderDishInfo);
    }

    /**
     * 删除一个订单_菜肴
     *
     * @param id 订单_菜肴ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @Override
    public int deleteOrderDishInfoById(@PathVariable Long id) {
        return orderDishInfoService.deleteOrderDishInfoByIdService(id);
    }


    /**
     * 删除多个订单_菜肴
     *
     * @param id 订单_菜肴ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteOrderDishInfoByIds(@RequestParam("id") List<Long> id) {
        return orderDishInfoService.deleteOrderDishInfoByIdsService(id);
    }

}
