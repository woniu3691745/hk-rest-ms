package com.team.hk.bookInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.hk.bookInfo.entity.BookInfo;
import com.team.hk.bookInfo.service.BookInfoService;
import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.menuInfo.service.MenuInfoService;
import com.team.hk.util.DateUtil;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lidongliang on 2017/7/10.
 * bookInfo 单体测试
 * 测试通过
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookInfoService bookInfoService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllBookInfo() throws Exception {

        BookInfo bookInfo = new BookInfo();
        String url = "/api/book/getAll/0/2";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(bookInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);

    }

    @Test
    public void addBookInfo() throws Exception {

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("xiaomingdingdan");
        bookInfo.setBookPhone(13478824245L);
        bookInfo.setBookTime(new Date());
        bookInfo.setStoreId(10011L);
        bookInfo.setTableId(100022L);
        bookInfo.setCreater("lidl");
        bookInfo.setModify("lidongliang");
        String url = "/api/book/add";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(bookInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }

    @Test
    public void deleteByIdBookInfo() throws Exception {

        String url = "/api/book/delete/2";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

    }


    @Test
    public void deleteByIdsBookInfo() throws Exception {

        String url = "/api/book/deleteAll";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .param("bookId", "3")
                .param("bookId", "4"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println("content =" + content);
        assertEquals(200, status);

    }

    @Test
    public void updateBookInfo() throws Exception {

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("12123123");
        bookInfo.setBookPhone(13478824245L);
        bookInfo.setBookTime(new Date());
        bookInfo.setStoreId(10011L);
        bookInfo.setTableId(100022L);
        bookInfo.setCreater("lidl");
        bookInfo.setModify("lidongliang");
        bookInfo.setBookId(1L);
        String url = "/api/book/update";

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(bookInfo)))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        assertEquals(200, status);
    }
}
