package com.team.hk.storeInfo.controller.impl;

import com.team.hk.storeInfo.controller.StoreInfoController;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.sys.entity.MessageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclets.internal.toolkit.builders.ClassBuilder.ROOT;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息实现类
 */
@Controller
@RequestMapping("/api/store")
public class StoreInfoControllerImpl implements StoreInfoController {

    private static Logger logger = Logger.getLogger(StoreInfoControllerImpl.class);

    @Autowired
    private StoreInfoService storeInfoService;

    private final ResourceLoader resourceLoader;

    private static final String ROOT = "storeImg";

    @Autowired
    public StoreInfoControllerImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获得门店信息（通过分页）
     *
     * @param storeInfo 门店entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> getAllStoreInfoByPage(@RequestBody StoreInfo storeInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<StoreInfo> menuInfos = storeInfoService.getAllStoreInfoByPageService(storeInfo, pageNo, pageSize);
        int count = storeInfoService.getAllStoreInfoCountByPageService(storeInfo, pageNo, pageSize);
        list.add(menuInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得门店信息
     *
     * @param storeInfo 门店entity
     * @return List<StoreInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> getAllStoreInfo(@RequestBody StoreInfo storeInfo) {
        return storeInfoService.getAllStoreInfoService(storeInfo);
    }

    /**
     * 增加门店信息
     *
     * @param storeInfo 门店entity
     * @return List<StoreInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> addStoreInfo(@RequestBody StoreInfo storeInfo) {
        return storeInfoService.addStoreInfoService(storeInfo);
    }

    /**
     * 修改门店信息
     *
     * @param storeInfo 门店entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateStoreInfo(@RequestBody StoreInfo storeInfo) {
        return storeInfoService.updateStoreInfoService(storeInfo);
    }


    /**
     * 删除一个门店
     *
     * @param storeId 门店ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{storeId}", method = RequestMethod.DELETE)
    @Override
    public int deleteStoreInfoById(@PathVariable("storeId") Long storeId) {
        return storeInfoService.deleteStoreInfoByIdService(storeId);
    }

    /**
     * 删除多个门店
     *
     * @param storeId 门店ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteStoreInfoByIds(@RequestParam("storeId") List<Long> storeId) {
        return storeInfoService.deleteStoreInfoByIdsService(storeId);
    }


    /**
     * 获得门店logo
     *
     * @param filename logo名字
     * @return ResponseEntity
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeLogoDown/{filename:.+}")
    public ResponseEntity<?> gettoreLogoDown(HttpServletRequest request, @PathVariable String filename) {
        try {
            String username = (String) request.getSession().getAttribute("username");
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT + "/" + username
                    + "/storeLogo/", filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 获得门店图片
     *
     * @param filename 门店图片名字
     * @return ResponseEntity
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeImgDown/{filename:.+}")
    public ResponseEntity<?> getStoreImgDown(HttpServletRequest request, @PathVariable String filename) {
        try {
            String username = (String) request.getSession().getAttribute("username");
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT + "/" + username
                    + "/storeImg/", filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 上传门店logo
     *
     * @param request req请求
     * @param img     logo名字
     * @return messageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/storeLogoUpload", method = RequestMethod.POST)
    public MessageInfo doUploadHeadImg(HttpServletRequest request, @RequestParam("img") MultipartFile img) {
        MessageInfo messageInfo = new MessageInfo();
        if (!img.isEmpty()) {
            try {
                String username = (String) request.getSession().getAttribute("username");
                FileUtils.copyInputStreamToFile(img.getInputStream(),
                        new File(String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeLogo/",
                                img.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.debug("上传成功");
            messageInfo.setCode(200);
            messageInfo.setMsg("上传成功.");
            return messageInfo;
        }
        logger.debug("上传失败,文件为空.");
        messageInfo.setCode(500);
        messageInfo.setMsg("上传失败,文件为空.");
        return messageInfo;
    }


    /**
     * 上传门店图片
     *
     * @param request req请求
     * @param file    门店图片
     * @return 门店图片
     */
    @ResponseBody
    @RequestMapping(value = "/storeImgUpload", method = RequestMethod.POST)
    public MessageInfo doUploadStoreImgs(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        MessageInfo messageInfo = new MessageInfo();
        if (!file.isEmpty()) {
            try {
                String username = (String) request.getSession().getAttribute("username");
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeImg/",
                                file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            messageInfo.setCode(200);
            messageInfo.setMsg("上传成功.");
            logger.debug("上传成功");
            return messageInfo;
        }
        messageInfo.setCode(500);
        messageInfo.setMsg("上传失败,文件为空.");
        logger.debug("上传失败,文件为空.");
        return messageInfo;
    }


    /**
     * 获得门店图片请求
     *
     * @param request 请求
     * @return 门店图片的集合
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeImgDowns")
    @ResponseBody
    public List getFiles(HttpServletRequest request) {

        List<String> list = new ArrayList<>();
        String username = (String) request.getSession().getAttribute("username");
        list.add("api/store/storeImgDown/img.jpg");
        list.add("api/store/storeImgDown/b1.jpg");
        list.add("api/store/storeImgDown/me2.jpg");
        list.add("api/store/storeImgDown/me.jpg");
        return list;
    }

}
