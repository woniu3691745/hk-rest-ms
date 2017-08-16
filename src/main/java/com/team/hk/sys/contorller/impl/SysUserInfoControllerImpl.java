package com.team.hk.sys.contorller.impl;

import com.team.hk.common.ConstantUtil;
import com.team.hk.sys.contorller.SysUserInfoController;
import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysUserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<SysUserInfo> getAllSysUserInfoByPage(@RequestBody SysUserInfo sysUserInfo,
                                                     @PathVariable("pageNo") Long pageNo,
                                                     @PathVariable("pageSize") Long pageSize,
                                                     HttpServletRequest request) {

        logger.debug("====>系统用户信息: " + sysUserInfo.toString());

        List list = new ArrayList();
        Long userId = Long.valueOf(request.getSession().getAttribute(ConstantUtil.KEY1).toString());
        String userRole = (String) request.getSession().getAttribute(ConstantUtil.KEY3);

        /**
         * 1.角色是admin登录，查询boss用户
         * 2.角色是boss登录，查询user用户
         */
        if (userRole != null && userRole.contains(ConstantUtil.ROLE_ADMIN)) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserRole(userRole);
            sysUserInfo.setUserType(ConstantUtil.USER_TYPE_BOSS);
        } else if (userRole != null && userRole.contains(ConstantUtil.ROLE_BOSS)) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserRole(userRole);
            sysUserInfo.setUserType(ConstantUtil.USER_TYPE_STORE);
        } else if (userRole != null && userRole.contains(ConstantUtil.ROLE_USER)) {
            sysUserInfo.setUserRole(userRole);
            sysUserInfo.setUserId(userId);
        }
        Long pn = (pageNo - 1) * pageSize;
        Long ps = pageSize;
        List<SysUserInfo> sysUserInfos =
                sysUserInfoService.getAllSysUserInfoByPageService(sysUserInfo, pn, ps);
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
    public List<SysUserInfo> getAllSysUserInfo(@RequestBody SysUserInfo sysUserInfo,
                                               HttpServletRequest request) {

        logger.debug("====>系统用户信息: " + sysUserInfo.toString());
        String userId = (String) request.getSession().getAttribute(ConstantUtil.KEY1);
        String userRole = (String) request.getSession().getAttribute(ConstantUtil.KEY3);
        sysUserInfo.setUserId(Long.parseLong(userId));

        /* 角色是user的需要返回storeId */
        if (userRole != null && userRole.contains(ConstantUtil.ROLE_USER)) {
            return sysUserInfoService.getAllSysUserInfoService(sysUserInfo);
        } else {
            List<SysUserInfo> allSysUserInfoService = sysUserInfoService.getAllSysUserInfoService(sysUserInfo);
            // 其他用户可能包含多个门店，因为只需要返回用户信息，所以如下coding
            if (allSysUserInfoService.size() > 0) {
                allSysUserInfoService.get(0).setStoreId(null);
            }
            return allSysUserInfoService;
        }
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
    public List<SysUserInfo> addSysUserInfo(@RequestBody SysUserInfo sysUserInfo,
                                            HttpServletRequest request) {

        logger.debug("====>添加系统用户: " + sysUserInfo.toString());

        Long userId = Long.valueOf(request.getSession().getAttribute(ConstantUtil.KEY1).toString());
        String userRole = (String) request.getSession().getAttribute(ConstantUtil.KEY3);

        /* admin用户登录 */
        if (userRole != null && userRole.contains(ConstantUtil.ROLE_ADMIN)) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(ConstantUtil.USER_TYPE_BOSS);
            sysUserInfo.setUserRole(ConstantUtil.ROLE_BOSS);
        /* boss用户登录 */
        } else if (userRole != null && userRole.contains(ConstantUtil.ROLE_BOSS)) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(ConstantUtil.USER_TYPE_STORE);
            sysUserInfo.setUserRole(ConstantUtil.ROLE_USER);
        }

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
        logger.debug("====>更改系统用户: " + sysUserInfo.toString());
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
    public int deleteSysUserInfoById(@PathVariable("userId") Long userId, HttpServletRequest request) {
        logger.debug("====>删除系统用户: " + userId);
        return sysUserInfoService.deleteSysUserInfoByIdService(userId, request);
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
    public int deleteSysUserInfoByIds(@RequestParam("userId") List<Long> userId, HttpServletRequest request) {
        logger.debug("====>删除系统用户: " + userId.toString());
        return sysUserInfoService.deleteSysUserInfoByIdsService(userId, request);
    }
}
