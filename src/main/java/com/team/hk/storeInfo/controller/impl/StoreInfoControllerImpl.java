package com.team.hk.storeInfo.controller.impl;

import com.team.hk.common.ConstantUtil;
import com.team.hk.storeInfo.controller.StoreInfoController;
import com.team.hk.storeInfo.entity.StoreImg;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import com.team.hk.common.MessageInfo;
import com.team.hk.util.FileUtil;
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

    /* class path: "classpath:" */
    private final ResourceLoader resourceLoader;

    /**
     * 存放门店logo和门店图片路径
     */
    private static final String ROOT_IMG = "store/img/";
    private static final String ROOT_LOGO = "store/logo/";

    @Autowired
    public StoreInfoControllerImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获得门店信息（通过分页）
     *
     * @param storeInfo 门店实体
     * @param pageNo    页数
     * @param pageSize  数量
     * @return 门店信息结果集
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> getAllStoreInfoByPage(@RequestBody StoreInfo storeInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize, HttpServletRequest request) {

        logger.debug("====> " + storeInfo.toString());
        List list = new ArrayList();
        String userRole = (String) request.getSession().getAttribute(ConstantUtil.KEY3);

        /* admin登录查询全部信息 */
        if (userRole != null && userRole.contains(ConstantUtil.ROLE_ADMIN)) {
            storeInfo.setUserId(null);
        }
        Long pn = (pageNo - 1) * pageSize;
        Long ps = pageSize;
        List<StoreInfo> menuInfos = storeInfoService.getAllStoreInfoByPageService(storeInfo, pn, ps);
        int count = storeInfoService.getAllStoreInfoCountByPageService(storeInfo, pageNo, pageSize);
        list.add(menuInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得门店信息
     *
     * @param storeInfo 门店实体
     * @return 门店信息结果集
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> getAllStoreInfo(@RequestBody StoreInfo storeInfo, HttpServletRequest request) {

        logger.debug("====> " + storeInfo.toString());

        Long userId = Long.valueOf(request.getSession().getAttribute(ConstantUtil.KEY1).toString());
        String userRole = (String) request.getSession().getAttribute(ConstantUtil.KEY3);

        /* boss登录 */
        if (userRole != null && userRole.contains(ConstantUtil.ROLE_BOSS)) {
            storeInfo.setUserId(userId);
        }
        return storeInfoService.getAllStoreInfoService(storeInfo);
    }

    /**
     * 增加门店信息
     *
     * @param storeInfo 门店实体
     * @return 门店信息结果集
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<StoreInfo> addStoreInfo(@RequestBody StoreInfo storeInfo, HttpServletRequest request) {

        logger.debug("====> 保存门店信息: " + storeInfo.toString());
        storeInfo.setUserId(Long.valueOf(request.getSession().getAttribute(ConstantUtil.KEY1).toString()));
        return storeInfoService.addStoreInfoService(storeInfo);
    }

    /**
     * 修改门店信息
     *
     * @param storeInfo 门店实体
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateStoreInfo(@RequestBody StoreInfo storeInfo) {

        logger.debug("====> 修改门店信息: " + storeInfo.toString());
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

        logger.debug("====> 删除门店ID: " + storeId);

        List<String> storeImg = storeInfoService.getStoreImg(storeId);
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(storeId);

        List<StoreInfo> storeInfoList = storeInfoService.getAllStoreInfoService(storeInfo);
        int num = storeInfoService.deleteStoreInfoByIdService(storeId);
        /* 删除门店成功后 */
        if (num != 0) {
            if (storeImg.size() > 0) {
                for (String path : storeImg) {
                    String[] filePath = path.split("/");
                    /* 删除门店图片 */
                    FileUtil.deleteFolder(new File(ROOT_IMG + filePath[3]));
                }
            }
            if (storeInfoList.size() > 0 && storeInfoList.get(0).getStoreLogo() != null) {
                /* 删除门店logo */
                FileUtil.deleteFolder(new File(ROOT_LOGO + storeInfoList.get(0).getStoreLogo().split("/")[0]));
            }
        }
        return num;
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

        logger.debug("====> 删除门店ID: " + storeId.toString());
        return storeInfoService.deleteStoreInfoByIdsService(storeId);
    }

    /**
     * 删除门店图片
     *
     * @param storeImg 文件路径
     * @return 删除门店图片信息
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/delStoreImg")
    @Override
    public MessageInfo deleteStoreImg(@RequestBody StoreImg storeImg) {

        logger.debug("====> 删除门店图片: " + storeImg.toString());
        storeInfoService.deleteStoreImg(storeImg);

        MessageInfo messageInfo = new MessageInfo();
        String[] split = storeImg.getImgUrl().split("/");
        messageInfo.setMsg(split[3] + "/" + split[4]);

        /* 物理删除 */
        String delPath = split[3];
        FileUtil.deleteFolder(new File(ROOT_IMG + delPath));

        return messageInfo;
    }


    /**
     * 1.获得门店logo
     * 2.新增页面
     *
     * @param filename logo名字
     * @param path     图片路径
     * @return 图片路径
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add/storeLogoDown/{path}/{filename:.+}")
    public ResponseEntity<?> doAddStoreLogoDown(@PathVariable String filename,
                                                @PathVariable String path) {
        try {
            logger.debug("====> logo名字: " + resourceLoader.getResource("file:"
                    + Paths.get(ROOT_LOGO + path, filename).toString()));
            return ResponseEntity.ok(resourceLoader.getResource("file:"
                    + Paths.get(ROOT_LOGO + path, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 1.获得门店logo
     * 2.通过门店ID获得门店log,
     * 给编辑页面
     *
     * @param storeId 门店ID
     * @return 图片路径
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit/storeLogoDown/{storeId}/{filename:.+}")
    public ResponseEntity<?> doEditStoreLogoDown(@PathVariable String storeId) {

        try {
            StoreInfo storeInfo = new StoreInfo();
            storeInfo.setStoreId(Long.valueOf(storeId));
            List<StoreInfo> allStoreInfoService = storeInfoService.getAllStoreInfoService(storeInfo);
            if (allStoreInfoService.size() != 0) {
                if (allStoreInfoService.get(0).getStoreLogo() != null) {
                    String storeLogoPath;
                    storeLogoPath = allStoreInfoService.get(0).getStoreLogo();
                    logger.debug("====> logo名字: "
                            + resourceLoader.getResource("file:" + ROOT_LOGO + storeLogoPath));
                    return ResponseEntity.ok(resourceLoader.getResource("file:" + ROOT_LOGO + storeLogoPath));
                }
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 获得门店图片
     *
     * @param filename 门店图片名字
     * @return 图片路径
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeImgDown/{path}/{filename:.+}")
    public ResponseEntity<?> doStoreImgDown(@PathVariable Long path,
                                            @PathVariable String filename) {
        try {
            logger.debug("====> 门店图片名字: "
                    + resourceLoader.getResource("file:" + Paths.get(ROOT_IMG + path, filename).toString()));
            return ResponseEntity.ok(resourceLoader.getResource("file:"
                    + Paths.get(ROOT_IMG + path, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 上传门店logo
     *
     * @param img logo名字
     * @return 消息结果集
     */
    @ResponseBody
    @RequestMapping(value = "/storeLogoUpload/{path}", method = RequestMethod.POST)
    public MessageInfo doUploadLogoImg(@RequestParam("img") MultipartFile img,
                                       @PathVariable String path) {
        MessageInfo messageInfo = new MessageInfo();
        if (!img.isEmpty()) {
            try {
                FileUtils.copyInputStreamToFile(img.getInputStream(),
                        new File(ROOT_LOGO + path, img.getOriginalFilename()));
                logger.debug("====> 上传头像成功: "
                        + ROOT_LOGO + path + "/" + img.getOriginalFilename());
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
     * @param file 门店图片
     * @return 消息结果集
     */
    @ResponseBody
    @RequestMapping(value = "/storeImgUpload", method = RequestMethod.POST)
    public MessageInfo doUploadStoreImg(@RequestParam("file") MultipartFile file) {

        MessageInfo messageInfo = new MessageInfo();
        String path = String.valueOf(System.currentTimeMillis());
        if (!file.isEmpty()) {
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(ROOT_IMG + path, file.getOriginalFilename()));
                logger.debug("====> 上传门店图片成功: "
                        + ROOT_IMG + path + "/" + file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            messageInfo.setCode(200);
            /* 用于唯一文件名,前端需要 */
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
    public List getStoreImgPath(@RequestBody StoreImg storeImg) {
        return storeInfoService.getStoreImg(storeImg.getStoreId());
    }

}
