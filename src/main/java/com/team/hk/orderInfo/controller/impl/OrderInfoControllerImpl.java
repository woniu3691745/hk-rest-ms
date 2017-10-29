package com.team.hk.orderInfo.controller.impl;

import com.team.hk.orderInfo.controller.OrderInfoController;
import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.entity.OrderToDishInfo;
import com.team.hk.orderInfo.service.OrderInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单接口实现类
 */
@Controller
@RequestMapping("/api/order")
public class OrderInfoControllerImpl implements OrderInfoController {

    private static Logger logger = Logger.getLogger(OrderInfoControllerImpl.class);

    @Autowired
    private OrderInfoService orderInfoService;


    /**
     * 获得订单信息（通过分页）
     *
     * @param orderInfo 订单实体
     * @param pageNo    页数
     * @param pageSize  数量
     * @return orderInfoInfo
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<OrderInfo> getAllOrderInfoByPage(@RequestBody OrderInfo orderInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        Long pn = (pageNo - 1) * pageSize;
        Long ps = pageSize;
        List<OrderInfo> orderInfos = orderInfoService.getAllOrderInfoByPageService(orderInfo, pn, ps);
        int count = orderInfoService.getAllOrderInfoCountByPageService(orderInfo, pageNo, pageSize);
        list.add(orderInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得订单信息
     *
     * @return orderInfo 订单实体
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<OrderInfo> getAllOrderInfo(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.getAllOrderInfoService(orderInfo);
    }

    /**
     * 增加订单
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addOrderInfo(@RequestBody OrderInfo orderInfo) {
        logger.debug("====> 订单信息: " + orderInfo.toString());
        return orderInfoService.addOrderInfoService(orderInfo, orderInfo.getOrderDishInfo());
    }

    /**
     * 修改订单
     *
     * @param orderInfo 订单实体
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateOrderInfo(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.updateOrderInfoService(orderInfo);
    }

    /**
     * 删除一个订单
     *
     * @param orderId 订单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.DELETE)
    @Override
    public int deleteOrderInfoById(@PathVariable("orderId") Long orderId) {
        return orderInfoService.deleteOrderInfoByIdService(orderId);
    }

    /**
     * 删除多个订单
     *
     * @param orderId 订单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteOrderInfoByIds(@RequestParam("orderId") List<Long> orderId) {
        return orderInfoService.deleteOrderInfoByIdsService(orderId);
    }

    /**
     * 获得订单对订单_菜肴信息
     *
     * @param orderToDishInfo 订单对订单_菜肴实体类
     * @return orderToDishInfo
     */
    @ResponseBody
    @RequestMapping(value = "/getOrderToDishList", method = RequestMethod.POST)
    @Override
    public List<OrderToDishInfo> listOrderToDish(@RequestBody OrderToDishInfo orderToDishInfo) {
        return orderInfoService.listOrderToDish(orderToDishInfo);
    }
}
