package com.team.hk.sys.contorller.impl;

import com.team.hk.sys.contorller.SysMenuInfoController;
import com.team.hk.sys.entity.MenuFormatInfo;
import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.server.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单信息实现类
 */
@Controller
@RequestMapping("/api/sysMenu")
public class SysMenuInfoControllerImpl implements SysMenuInfoController {


    @Autowired
    private SysMenuInfoService sysMenuInfoService;

    /**
     * 获得系统菜单信息
     *
     * @return List<SysMenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<MenuFormatInfo> getAllSysMenuInfo() {
        List<MenuFormatInfo> listInfo = new ArrayList<>();

        // 获得数据
        List<SysMenuInfo> sysMenuInfosBase = sysMenuInfoService.getAllSysMenuInfoService(new SysMenuInfo());

        // 过滤掉子菜单
        List<SysMenuInfo> sysMenuInfos = sysMenuInfosBase
                .stream()
                .filter(sysMenuInfo -> sysMenuInfo.getParent() == null)
                .collect(Collectors.toList());

        // 保存菜单
        for (SysMenuInfo i : sysMenuInfos) {
            MenuFormatInfo menuFormat = new MenuFormatInfo();
            if (i.getParent() == null) {
                menuFormat.setId(i.getId());
                menuFormat.setPath(i.getPath());
                menuFormat.setName(i.getName());
                menuFormat.setIcon(i.getIcon());
                menuFormat.setRole(i.getRole().split(","));
                menuFormat.setComponent(i.getComponent());
                menuFormat.setRedirect(i.getRedirect());
            }
            listInfo.add(menuFormat);
        }

        // 用全部菜单去匹配父菜单
        for (MenuFormatInfo parentInfo : listInfo) {
            List<MenuFormatInfo> listChildrenInfo = new ArrayList<>();
            sysMenuInfosBase.stream()
                    .filter(base -> base.getParent() != null)
                    .filter(base -> Objects.equals(base.getParent(), parentInfo.getId()))
                    .forEach(base -> {
                        MenuFormatInfo menuChildrenFormat = new MenuFormatInfo();
                        menuChildrenFormat.setId(base.getId());
                        menuChildrenFormat.setPath(base.getPath());
                        menuChildrenFormat.setName(base.getName());
                        menuChildrenFormat.setParent(parentInfo.getId());
                        menuChildrenFormat.setComponent(base.getComponent());
                        menuChildrenFormat.setIcon(base.getIcon());
                        menuChildrenFormat.setRole(base.getRole().split(","));
                        menuChildrenFormat.setRedirect("");
                        menuChildrenFormat.setChildren(new ArrayList<>());
                        listChildrenInfo.add(menuChildrenFormat);
                        parentInfo.setChildren(listChildrenInfo);
                    });
        }

        return listInfo;
    }


    /**
     * 获得系统菜单信息（通过分页）
     *
     * @param sysMenuInfo 系统菜单entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysMenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<SysMenuInfo> getAllSysMenuInfoByPage(@RequestBody SysMenuInfo sysMenuInfo, @PathVariable("pageNo") Long pageNo,
                                                     @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<SysMenuInfo> sysMenuInfos = sysMenuInfoService.getAllSysMenuInfoByPageService(sysMenuInfo, pageNo, pageSize);
        int count = sysMenuInfoService.getAllSysMenuInfoCountByPageService(sysMenuInfo, pageNo, pageSize);
        list.add(sysMenuInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得系统菜单信息
     *
     * @param menuId 系统菜单ID
     * @return List<SysMenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get/{menuId}", method = RequestMethod.GET)
    @Override
    public List<SysMenuInfo> getAllSysMenuInfo(@PathVariable("menuId") Long menuId) {
        SysMenuInfo sysMenuInfo = new SysMenuInfo();
        sysMenuInfo.setId(menuId);
        return sysMenuInfoService.getAllSysMenuInfoService(sysMenuInfo);
    }


    /**
     * 增加系统菜单信息
     *
     * @param sysMenuInfo 系统菜单entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addSysMenuInfo(@RequestBody SysMenuInfo sysMenuInfo) {
        return sysMenuInfoService.addSysMenuInfoService(sysMenuInfo);
    }

    /**
     * 修改系统菜单信息
     *
     * @param sysMenuInfo 系统菜单entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateSysMenuInfo(@RequestBody SysMenuInfo sysMenuInfo) {
        return sysMenuInfoService.updateSysMenuInfoService(sysMenuInfo);
    }

    /**
     * 删除一个系统菜单信息
     *
     * @param menuId 系统菜单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{menuId}", method = RequestMethod.DELETE)
    @Override
    public int deleteSysMenuInfoById(@PathVariable("menuId") Long menuId) {
        return sysMenuInfoService.deleteSysMenuInfoByIdService(menuId);
    }

    /**
     * 删除多个系统菜单信息
     *
     * @param menuId 系统菜单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteSysMenuInfoByIds(@RequestParam("menuId") List<Long> menuId) {
        return sysMenuInfoService.deleteSysMenuInfoByIdsService(menuId);
    }
}
