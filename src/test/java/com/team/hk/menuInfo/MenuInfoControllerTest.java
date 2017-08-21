package com.team.hk.menuInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.menuInfo.service.MenuInfoService;
import com.team.hk.orderInfo.entity.OrderInfo;
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
 * MenuInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MenuInfoService menuInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllMenuInfo() throws Exception {

        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setDishesId(1L);
        String url = "/api/menu/getAll/0/2";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(menuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void getAllMenuInfoByParams() throws Exception {

        MenuInfo menuInfo = new MenuInfo();
//        menuInfo.setDishesId(2L);
        menuInfo.setMenuId(2L);
        String url = "/api/menu/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(menuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void addMenuInfo() throws Exception {

        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setMenuId(10001L);
        menuInfo.setStoreId(10002L);
        menuInfo.setDishesPrice(20.35);
        menuInfo.setDishesName("水煮肉");
        menuInfo.setDishesDiscountPrice("0.8");
        menuInfo.setDishesDescription("鱼水肉");
        menuInfo.setDishesCategory(1);
        menuInfo.setDishesImg(333L);
        menuInfo.setDishesWaterStatus(1);
        menuInfo.setIsVegetarian(1);
        menuInfo.setStock(1);
        menuInfo.setOverplusStock(1);
        menuInfo.setCreater("lidl");
        menuInfo.setModify("lidongliang");
        String url = "/api/menu/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(menuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdMenuInfo() throws Exception {

        String url = "/api/menu/delete/1";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }


    @Test
    public void deleteByIdsMenuInfo() throws Exception {

        String url = "/api/menu/deleteAll";
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("dishesId", "3")
                .param("dishesId", "4"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void updateMenuInfo() throws Exception {

        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setMenuId(2L);
        menuInfo.setStoreId(10002L);
        menuInfo.setDishesPrice(30.35);
        menuInfo.setDishesName("水煮肉1");
        menuInfo.setDishesDiscountPrice("0.8");
        menuInfo.setDishesDescription("鱼水肉");
        menuInfo.setDishesCategory(1);
        menuInfo.setDishesImg(333L);
        menuInfo.setDishesWaterStatus(1);
        menuInfo.setIsVegetarian(1);
        menuInfo.setStock(1);
        menuInfo.setOverplusStock(1);
        menuInfo.setCreater("lidl");
        menuInfo.setModify("lidongliang");
        menuInfo.setDishesId(2L);
        String url = "/api/menu/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(menuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void menuInfoByParams() throws Exception {

        MenuInfo menuInfo = new MenuInfo();
        String url = "/api/menu/menuInfoByCategory";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }
}
