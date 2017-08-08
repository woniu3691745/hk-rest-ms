package com.team.hk.sys.contorller.impl;

import com.team.hk.sys.contorller.SysUserInfoController;
import com.team.hk.sys.entity.MessageInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysUserInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclets.internal.toolkit.builders.ClassBuilder.ROOT;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统用户信息实现类
 */
@Controller
@RequestMapping("/api/sysUser")
public class SysUserInfoControllerImpl implements SysUserInfoController {

    private static Logger logger = Logger.getLogger(SysUserInfoControllerImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysUserInfoService sysUserInfoService;


    private final ResourceLoader resourceLoader;

    @Autowired
    public SysUserInfoControllerImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 上传头像
     *
     * @param request req请求
     * @param headImg 头像
     * @return messageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/headUpload", method = RequestMethod.POST)
    @Override
    public MessageInfo doUploadHeadImg(HttpServletRequest request, @RequestParam("headImg") MultipartFile headImg) {
        MessageInfo messageInfo = new MessageInfo();
        if (!headImg.isEmpty()) {
            try {
                System.out.println(Paths.get(ROOT, headImg.getOriginalFilename()));
                FileUtils.copyInputStreamToFile(headImg.getInputStream(), new File(String.valueOf(Paths.get(ROOT)),
                        headImg.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            messageInfo.setCode(200);
            messageInfo.setMsg("上传成功.");
            return messageInfo;
        }
        messageInfo.setCode(500);
        messageInfo.setMsg("上传失败,文件为空.");
        return messageInfo;
    }

    /**
     * 获得头像
     *
     * @param filename 文件名字
     * @return ResponseEntity
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getImg/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 获得系统用户信息（通过分页）
     *
     * @param sysUserInfo 系统用户entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> getAllSysUserInfoByPage(@RequestBody SysUserInfo sysUserInfo, @PathVariable("pageNo") Long pageNo,
                                                     @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<SysUserInfo> sysUserInfos = sysUserInfoService.getAllSysUserInfoByPageService(sysUserInfo, pageNo, pageSize);
        int count = sysUserInfoService.getAllSysUserInfoCountByPageService(sysUserInfo, pageNo, pageSize);
        list.add(sysUserInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> getAllSysUserInfo(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        sysUserInfo.setUserId(Long.parseLong(userId));
        return sysUserInfoService.getAllSysUserInfoService(sysUserInfo);
    }


    /**
     * 增加系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> addSysUserInfo(@RequestBody SysUserInfo sysUserInfo) {
        return sysUserInfoService.addSysUserInfoService(sysUserInfo);
    }

    /**
     * 修改系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateSysUserInfo(@RequestBody SysUserInfo sysUserInfo) {
        return sysUserInfoService.updateSysUserInfoService(sysUserInfo);
    }

    /**
     * 删除一个系统用户信息
     *
     * @param userId 系统用户ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    @Override
    public int deleteSysUserInfoById(@PathVariable("userId") Long userId) {
        return sysUserInfoService.deleteSysUserInfoByIdService(userId);
    }

    /**
     * 删除多个系统用户
     *
     * @param userId 系统用户ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteSysUserInfoByIds(@RequestParam("userId") List<Long> userId) {
        return sysUserInfoService.deleteSysUserInfoByIdsService(userId);
    }
}
