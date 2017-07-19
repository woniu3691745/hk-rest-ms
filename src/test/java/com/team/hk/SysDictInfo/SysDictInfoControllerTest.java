package com.team.hk.SysDictInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.sys.entity.SysDictInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysDictInfoService;
import com.team.hk.sys.server.SysUserInfoService;
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

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lidongliang on 2017/7/4.
 * SysDictInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysDictInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SysDictInfoService sysDictInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllDictInfo() throws Exception {

        SysDictInfo sysDictInfo = new SysDictInfo();
        String url = "/api/sysDict/getAll/0/3";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysDictInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void getAllDictInfoByParams() throws Exception {

        SysDictInfo sysDictInfo = new SysDictInfo();
        sysDictInfo.setId(1L);
        String url = "/api/sysDict/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysDictInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void addDictInfo() throws Exception {

        SysDictInfo sysDictInfo = new SysDictInfo();
        sysDictInfo.setTypeId(90001L);
        sysDictInfo.setTypeName("用户角色2");
        sysDictInfo.setValue("user1");
        sysDictInfo.setName("用户4");
        sysDictInfo.setModify("lidongliang");
        sysDictInfo.setCreater("lidongliang");
        String url = "/api/sysDict/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysDictInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void updateDictInfo() throws Exception {

        SysDictInfo sysDictInfo = new SysDictInfo();
        sysDictInfo.setTypeId(90001L);
        sysDictInfo.setTypeName("a用户角色");
        sysDictInfo.setValue("admin2");
        sysDictInfo.setName("管d理员");
        sysDictInfo.setModify("lidongliang");
        sysDictInfo.setId(5L);
        String url = "/api/sysDict/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysDictInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdDictInfo() throws Exception {

        String url = "/api/sysDict/delete/5";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void deleteByIdsDictInfo() throws Exception {

        String url = "/api/sysDict/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("dictId", "3")
                .param("dictId", "6"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }
}
