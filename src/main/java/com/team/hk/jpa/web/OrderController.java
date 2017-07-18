package com.team.hk.jpa.web;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.team.hk.jpa.Repository.OrderRepository;
import com.team.hk.jpa.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/29.
 * JPA 控制层
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderController {

    Log log = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderInfo> getOrders() {
        Long orderId = 1l;
        List<OrderInfo> orderInfo = orderRepository.findAllByOrderId(orderId);
        return orderInfo;
    }
}
