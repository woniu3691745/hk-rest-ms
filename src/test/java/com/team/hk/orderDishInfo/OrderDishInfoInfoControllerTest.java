package com.team.hk.orderDishInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.orderInfo.entity.OrderDishInfo;
import com.team.hk.orderInfo.entity.OrderInfo;
import com.team.hk.orderInfo.service.OrderDishInfoService;
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

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lidongliang on 2017/7/4.
 * OrderDishInfoInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDishInfoInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllOrderDishInfo() throws Exception {
        String url = "/api/orderDish/getAll/8";
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void addOrderDishInfo() throws Exception {

        // 在订单里测试
    }

    @Test
    public void deleteByIdOrderDishInfo() throws Exception {
        String url = "/api/orderDish/delete/10";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdsOrderDishInfo() throws Exception {
        String url = "/api/orderDish/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "11")
                .param("id", "12"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void updateOrderDishInfo() throws Exception {
        OrderDishInfo orderDishInfo = new OrderDishInfo();
        orderDishInfo.setId(22L);
        orderDishInfo.setAmount(2);
        orderDishInfo.setMenuId(11L);
        orderDishInfo.setOrderId(12L);
        orderDishInfo.setDishesDiscountPrice("10%");
        orderDishInfo.setDishesPrice(10F);
        orderDishInfo.setDishesId(1234L);
        orderDishInfo.setDishesName("大虾");
        String url = "/api/orderDish/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(orderDishInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }
}
