package com.team.hk.tableInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.tableInfo.entity.TableInfo;
import com.team.hk.tableInfo.service.TableInfoService;
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
 * TableInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TableInfoService tableInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllTableInfo() throws Exception {

        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(1L);
        String url = "/api/table/getAll/0/2";

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
    public void getAllTableInfoByParams() throws Exception {

        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableId(5L);
        String url = "/api/table/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tableInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void getAllTableInfoById() throws Exception {

        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableId(1L);
        String url = "/api/table/get";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tableInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void addTableInfo() throws Exception {

        TableInfo tableInfo = new TableInfo();
        tableInfo.setStoreId(1L);
        tableInfo.setTableDescription("aaa");
        tableInfo.setTableStatus(0);
        tableInfo.setCreater("lidongliang");
        tableInfo.setModify("xiaoming");
        String url = "/api/table/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tableInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdTableInfo() throws Exception {

        String url = "/api/table/delete/1";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void deleteByIdsTableInfo() throws Exception {

        String url = "/api/table/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("tableId", "1")
                .param("tableId", "3"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void updateTableInfo() throws Exception {

        TableInfo tableInfo = new TableInfo();
        tableInfo.setStoreId(2L);
        tableInfo.setTableDescription("a123eaa");
        tableInfo.setTableStatus(0);
        tableInfo.setModify("xiaomin1g");
        tableInfo.setTableId(1L);
        String url = "/api/table/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tableInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

}
