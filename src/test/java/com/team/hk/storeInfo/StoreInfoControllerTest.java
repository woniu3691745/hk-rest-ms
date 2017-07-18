package com.team.hk.storeInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
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

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lidongliang on 2017/7/4.
 * StoreInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StoreInfoService storeInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllStoreInfo() throws Exception {

        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(1L);
        String url = "/api/store/getAll/0/2";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(storeInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void getAllStoreInfoById() throws Exception {

        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(1L);
        String url = "/api/store/get/1";

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
    public void addStoreInfo() throws Exception {

        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setUserId(1001L);
        storeInfo.setStoreName("aibaba");
        storeInfo.setStorePhone(13478824245L);
        storeInfo.setStoreAddress("ddss1212");
        storeInfo.setStoreAdmin("aaaa");
        storeInfo.setStoreDescription("dddddd");
        storeInfo.setStoreLogo("D:\\asd");
        storeInfo.setStoreStatus(1);
        storeInfo.setStoreNotice("123213");
        storeInfo.setStoreImg("123123213");
        storeInfo.setStoreType(1);
        storeInfo.setSeatCost(22.11f);
        storeInfo.setServiceCost("10%");
        storeInfo.setStoreBusinessAmStartHours(new Date());
        storeInfo.setStoreBusinessAmEndHours(new Date());
        storeInfo.setStoreBusinessPmStartHours(new Date());
        storeInfo.setStoreBusinessPmEndHours(new Date());
        storeInfo.setCreater("111");
        storeInfo.setModify("2222");
        storeInfo.setStatus(0);
        String url = "/api/store/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(storeInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdStoreInfo() throws Exception {

        String url = "/api/store/delete/1";
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void deleteByIdsStoreInfo() throws Exception {
        String url = "/api/store/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", "3")
                .param("storeId", "4"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void updateStoreInfo() throws Exception {

        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(1L);
        storeInfo.setUserId(1001L);
        storeInfo.setStoreName("李栋梁1111");
        storeInfo.setStorePhone(13478824245L);
        storeInfo.setStoreAddress("ddss1212");
        storeInfo.setStoreAdmin("aaaa");
        storeInfo.setStoreDescription("dddddd");
        storeInfo.setStoreLogo("D:\\asd");
        storeInfo.setStoreStatus(1);
        storeInfo.setStoreNotice("123213");
        storeInfo.setStoreImg("123123213");
        storeInfo.setStoreType(1);
        storeInfo.setSeatCost(12.4f);
        storeInfo.setServiceCost("10%");
        storeInfo.setStoreBusinessAmStartHours(new Date());
        storeInfo.setStoreBusinessAmEndHours(new Date());
        storeInfo.setStoreBusinessPmStartHours(new Date());
        storeInfo.setStoreBusinessPmEndHours(new Date());
        storeInfo.setStoreBusinessDay("1");
        storeInfo.setCreater("111");
        storeInfo.setModify("2222");
        storeInfo.setStatus(0);

        String url = "/api/store/update";
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(storeInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }
}
