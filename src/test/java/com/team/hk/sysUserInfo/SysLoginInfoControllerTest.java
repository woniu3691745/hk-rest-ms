package com.team.hk.sysUserInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysLoginInfoService;
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
 * SysLoginInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLoginInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SysLoginInfoService sysLoginInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void TestLogin() throws Exception {

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserName("admin");
        sysUserInfo.setUserPassword("123456");
        String url = "/api/login";

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


}
