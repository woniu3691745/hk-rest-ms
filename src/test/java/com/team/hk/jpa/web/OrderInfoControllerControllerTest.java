package com.team.hk.jpa.web;

import com.team.hk.jpa.Repository.OrderRepository;
import com.team.hk.jpa.entity.OrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/29.
 * JAP 单元测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoControllerControllerTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void OrderRepositoryTest () {
        List<OrderInfo> list = orderRepository.findAllByOrderId(1l);
        System.out.println("list = " + list.toString());
    }
}
