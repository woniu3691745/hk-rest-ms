package com.team.hk.sysUserInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysUserInfoService;
import com.team.hk.tableInfo.entity.TableInfo;
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
 * SysUserInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllUserInfo() throws Exception {

        SysUserInfo sysUserInfo = new SysUserInfo();
//        sysUserInfo.setUserName("lidongliang");
//        sysUserInfo.setUserPassword("1");
        String url = "/api/sysUser/getAll/0/3";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysUserInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void getAllUserInfoByParams() throws Exception {

        SysUserInfo sysUserInfo = new SysUserInfo();
//        sysUserInfo.setUserId(4L);
        sysUserInfo.setUserName("lidongliang");
//        sysUserInfo.setUserPassword("a");
        String url = "/api/sysUser/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysUserInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void addUserInfo() throws Exception {

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserName("123123");
        sysUserInfo.setUserPassword("a");
        sysUserInfo.setUserPhone(13478824245L);
        sysUserInfo.setUserAddress("beijiang");
        sysUserInfo.setUserSex(1);
        sysUserInfo.setUserRole("admin, user");
        sysUserInfo.setCreater("ldl");
        sysUserInfo.setModify("xiaoming");

        String url = "/api/sysUser/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysUserInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void updateUserInfo() throws Exception {

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserName("lidongliang1");
        sysUserInfo.setUserPassword("a");
        sysUserInfo.setUserRole("admin, user");
        sysUserInfo.setUserPhone(13478824245L);
        sysUserInfo.setUserAddress("beijiang1");
        sysUserInfo.setUserSex(1);
        sysUserInfo.setCreater("ldl");
        sysUserInfo.setModify("xiaoming");
        sysUserInfo.setUserId(1L);

        String url = "/api/sysUser/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sysUserInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdUserInfo() throws Exception {

        String url = "/api/sysUser/delete/2";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void deleteByIdsUserInfo() throws Exception {

        String url = "/api/sysUser/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("userId", "3")
                .param("userId", "5"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }
}
