package com.team.hk.menuInfo.controller.impl;

import com.team.hk.menuInfo.controller.MenuInfoController;
import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.menuInfo.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息实现类
 */
@Controller
@RequestMapping("/api/menu")
public class MenuInfoControllerImpl implements MenuInfoController {

    private static Logger logger = Logger.getLogger(MenuInfoControllerImpl.class);

    @Autowired
    private MenuInfoService menuInfoService;

    /**
     * 获得菜单信息（通过分页）
     *
     * @param menuInfo 菜单entity
     * @param pageNo   页数
     * @param pageSize 数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<MenuInfo> getAllMenuInfoByPage(@RequestBody MenuInfo menuInfo, @PathVariable("pageNo") Long pageNo,
                                               @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<MenuInfo> menuInfos = menuInfoService.getAllMenuInfoByPageService(menuInfo, pageNo, pageSize);
        int count = menuInfoService.getAllMenuInfoCountByPageService(menuInfo, pageNo, pageSize);
        list.add(menuInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得菜单信息
     *
     * @param menuInfo 菜单entity
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<MenuInfo> getAllMenuInfo(@RequestBody MenuInfo menuInfo) {
        return menuInfoService.getAllMenuInfoService(menuInfo);
    }

    /**
     * 增加菜单信息
     *
     * @param menuInfo 菜单entity
     * @return 1rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addMenuInfo(@RequestBody MenuInfo menuInfo) {
        return menuInfoService.addMenuInfoService(menuInfo);
    }

    /**
     * 修改菜单
     *
     * @param menuInfo 菜单entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateMenuInfo(@RequestBody MenuInfo menuInfo) {
        return menuInfoService.updateMenuInfoService(menuInfo);
    }

    /**
     * 删除一个菜单
     *
     * @param dishesId 菜单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{dishesId}", method = RequestMethod.DELETE)
    @Override
    public int deleteMenuInfoById(@PathVariable("dishesId") Long dishesId) {
        return menuInfoService.deleteMenuInfoByIdService(dishesId);
    }

    /**
     * 删除多个菜单
     *
     * @param dishesId 菜单ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteMenuInfoByIds(@RequestParam("dishesId") List<Long> dishesId) {
        return menuInfoService.deleteMenuInfoByIdsService(dishesId);
    }
}
