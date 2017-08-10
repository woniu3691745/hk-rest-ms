package com.team.hk.storeInfo.controller.impl;

import com.team.hk.common.Constant;
import com.team.hk.storeInfo.controller.StoreInfoController;
import com.team.hk.storeInfo.entity.StoreImg;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.common.MessageInfo;
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
                                                 @PathVariable("pageSize") Long pageSize, HttpServletRequest request) {
        logger.debug("====> " + storeInfo.toString());
        List list = new ArrayList();
        String userRole = (String) request.getSession().getAttribute(Constant.KEY3);

        // admin登陆查询全部信息
        if (userRole != null && userRole.contains(Constant.ROULE_ADMIN)) {
            storeInfo.setUserId(null);
        }
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
    public List<StoreInfo> getAllStoreInfo(@RequestBody StoreInfo storeInfo, HttpServletRequest request) {

        Long userId = Long.valueOf(request.getSession().getAttribute(Constant.KEY1).toString());
        String userRole = (String) request.getSession().getAttribute(Constant.KEY3);

        if (userRole != null && userRole.contains(Constant.ROULE_BOSS)) {
            storeInfo.setUserId(userId);
        }
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
    public List<StoreInfo> addStoreInfo(@RequestBody StoreInfo storeInfo, HttpServletRequest request) {
        logger.debug("====> 保存门店信息 " + storeInfo.toString());
        storeInfo.setUserId(Long.valueOf(request.getSession().getAttribute(Constant.KEY1).toString()));
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
        logger.debug("====> 修改门店信息 " + storeInfo.toString());
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
        logger.debug("====> 删除门店ID " + storeId);
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
        logger.debug("====> 删除门店ID " + storeId.toString());
        return storeInfoService.deleteStoreInfoByIdsService(storeId);
    }

    /**
     * 删除门店图片
     *
     * @param storeImg 文件路径
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/delStoreImg")
    @Override
    public MessageInfo deleteStoreImg(@RequestBody StoreImg storeImg) {
        logger.debug("====> 删除门店图片 " + storeImg.toString());
        storeInfoService.deleteStoreImg(storeImg);
        MessageInfo messageInfo = new MessageInfo();
        String[] split = storeImg.getImgUrl().split("/");
        messageInfo.setMsg(split[3]+"/"+split[4]);
        return messageInfo;
    }


    /**
     * 获得门店logo
     *
     * @param filename logo名字
     * @return ResponseEntity
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeLogoDown/{filename:.+}")
    public ResponseEntity<?> getStoreLogoDown(HttpServletRequest request, @PathVariable String filename) {
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
    @RequestMapping(method = RequestMethod.GET, value = "/storeImgDown/{path}/{filename:.+}")
    public ResponseEntity<?> getStoreImgDown(HttpServletRequest request,
                                             @PathVariable Long path,
                                             @PathVariable String filename) {
        try {
            String username = (String) request.getSession().getAttribute("username");
            String filePath = Paths.get(ROOT + "/" + username
                    + "/storeImg/" + path).toString();
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(filePath, filename).toString()));
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
            String username = (String) request.getSession().getAttribute("username");
            try {
                FileUtils.copyInputStreamToFile(img.getInputStream(),
                        new File(String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeLogo/",
                                img.getOriginalFilename()));
                logger.debug("====> 上传头像成功 " + String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeLogo/" +
                        img.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }

            messageInfo.setCode(200);
            messageInfo.setMsg("上传头像成功.");
            return messageInfo;
        }
        logger.debug("====> 上传失败,文件为空.");
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
        String path = String.valueOf(System.currentTimeMillis());
        if (!file.isEmpty()) {
            String username = (String) request.getSession().getAttribute("username");
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeImg/"
                                + path, file.getOriginalFilename()));
                logger.debug("====> 上传门店图片成功 " + String.valueOf(Paths.get(ROOT)) + "/" + username + "/storeImg/"
                        + path + "/" + file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            messageInfo.setCode(200);
            // 用于唯一文件名
            messageInfo.setMsg1(path);
            messageInfo.setMsg("上传门店图片成功.");
            return messageInfo;
        }
        messageInfo.setCode(500);
        messageInfo.setMsg("上传失败,文件为空.");
        logger.debug("====> 上传失败,文件为空.");
        return messageInfo;
    }


    /**
     * 获得门店图片请求
     *
     * @return 门店图片的集合
     */
    @RequestMapping(method = RequestMethod.POST, value = "/storeImgDowns")
    @ResponseBody
    public List getFiles(@RequestBody StoreImg storeImg) {
        return storeInfoService.getStoreImg(storeImg.getStoreId());
    }

}
