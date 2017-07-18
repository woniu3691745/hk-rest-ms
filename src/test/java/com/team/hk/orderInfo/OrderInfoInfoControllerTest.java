package com.team.hk.orderInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.service.OrderInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lidongliang on 2017/7/4.
 * OrderInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OrderInfoService orderInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllOrderInfo() throws Exception {
        OrderInfo order = new OrderInfo();
        order.setStoreId(10L);
        String url = "/api/order/getAll/0/5";
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(order)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void addOrderInfo() throws Exception {
        // 订单信息
        OrderInfo order = new OrderInfo();
        order.setStoreId(10L);
        order.setTableId(121L);
        order.setOrderStatus(2);
        order.setOrderAmount(100.22f);
        order.setOrderCreater("Tony");
        order.setMember(8);
        order.setComment("测试");
        order.setCreater("李栋梁");
        order.setModify("李栋梁");

        // 菜肴信息，从菜单中获得
        OrderDishInfo orderDishInfo1 = new OrderDishInfo();
        orderDishInfo1.setDishesId(1012L);
        orderDishInfo1.setDishesName("红烧肉1");
        orderDishInfo1.setDishesPrice(38f);
        orderDishInfo1.setDishesDiscountPrice("8%");
        orderDishInfo1.setAmount(1);
        orderDishInfo1.setMenuId(1001L);
        orderDishInfo1.setCreater("李栋梁");
        orderDishInfo1.setModify("李栋梁");

        OrderDishInfo orderDishInfo2 = new OrderDishInfo();
        orderDishInfo2.setDishesId(1013L);
        orderDishInfo2.setDishesName("水煮鱼1");
        orderDishInfo2.setDishesPrice(98f);
        orderDishInfo2.setDishesDiscountPrice("18%");
        orderDishInfo2.setAmount(1);
        orderDishInfo2.setMenuId(1001L);
        orderDishInfo2.setCreater("李栋梁");
        orderDishInfo2.setModify("李栋梁");

        OrderDishInfo orderDishInfo3 = new OrderDishInfo();
        orderDishInfo3.setDishesId(1014L);
        orderDishInfo3.setDishesName("大鲍鱼");
        orderDishInfo3.setDishesPrice(98f);
        orderDishInfo3.setDishesDiscountPrice("18%");
        orderDishInfo3.setAmount(1);
        orderDishInfo3.setMenuId(1001L);
        orderDishInfo3.setCreater("李栋梁");
        orderDishInfo3.setModify("李栋梁");

        List<OrderDishInfo> list = new ArrayList<>();
        list.add(orderDishInfo1);
        list.add(orderDishInfo2);
        list.add(orderDishInfo3);
//        String url = "/api/order/add";
//        ObjectMapper mapper = new ObjectMapper();
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(order)))
//                .andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        String content = mvcResult.getResponse().getContentAsString();
//        System.out.println(content);
//        assertEquals(200, status);

        orderInfoService.addOrderInfoService(order, list);
    }

    @Test
    public void deleteByIdOrderInfo() throws Exception {
        String url = "/api/order/delete/9";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }


    @Test
    public void deleteByIdsOrderInfo() throws Exception {
        String url = "/api/order/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("orderId", "10")
                .param("orderId", "11"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void updateOrderInfo() throws Exception {
        OrderInfo order = new OrderInfo();
        order.setOrderId(12L);
        order.setStoreId(9L);
        order.setTableId(9L);
        order.setOrderStatus(9);
        order.setOrderAmount(9);
        order.setMember(9);
        order.setOrderCreater("李栋梁");
        order.setComment("XXXX");
        order.setModify("天天向上");
        String url = "/api/order/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(order)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }
}
