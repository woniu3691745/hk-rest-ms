package com.team.hk.sysMenuInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.sys.entity.SysMenuInfo;
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
 * SysMenuInfo 单体测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuInfoControllerTest {

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

        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        String url = "/api/sysMenu/getAll/0/3";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysMenuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

}
