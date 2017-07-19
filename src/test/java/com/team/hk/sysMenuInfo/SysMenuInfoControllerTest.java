package com.team.hk.sysMenuInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysMenuInfoService;
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
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SysMenuInfoService sysMenuInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllMenuInfo() throws Exception {

        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        String url = "/api/sysMenu/getAll/0/3";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysMenuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void getAllMenuInfoByParams() throws Exception {

        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        sysMenuInfo.setId(1001L);
        String url = "/api/sysMenu/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysMenuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void addMenuInfo() throws Exception {

        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        sysMenuInfo.setComponent("123");
        sysMenuInfo.setIcon("123");
        sysMenuInfo.setName("123");
        sysMenuInfo.setPath("123");
        sysMenuInfo.setRole("admin, user");
        sysMenuInfo.setCreater("lll");
        sysMenuInfo.setModify("llll");

        String url = "/api/sysMenu/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysMenuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void updateMenuInfo() throws Exception {

        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        sysMenuInfo.setComponent("asd");
        sysMenuInfo.setIcon("asd");
        sysMenuInfo.setName("123");
        sysMenuInfo.setPath("123");
        sysMenuInfo.setCreater("lll");
        sysMenuInfo.setModify("llll");
        sysMenuInfo.setId(1006L);

        String url = "/api/sysMenu/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysMenuInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdMenuInfo() throws Exception {

        String url = "/api/sysMenu/delete/1006";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void deleteByIdsMenuInfo() throws Exception {

        String url = "/api/sysMenu/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "3")
                .param("id", "5"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }
}
