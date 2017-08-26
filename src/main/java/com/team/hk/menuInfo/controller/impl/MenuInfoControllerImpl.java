package com.team.hk.menuInfo.controller.impl;

import com.alibaba.fastjson.JSON;
import com.team.hk.menuInfo.controller.MenuInfoController;
import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.menuInfo.entity.MenuInfoMobile;
import com.team.hk.menuInfo.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
        logger.debug("====>菜肴信息: " + menuInfo.toString());
        List list = new ArrayList();
        Long pn = (pageNo - 1) * pageSize;
        List<MenuInfo> menuInfos = menuInfoService.getAllMenuInfoByPageService(menuInfo, pn, pageSize);
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
        logger.debug("====>菜肴信息: " + menuInfo.toString());
        return menuInfoService.getAllMenuInfoService(menuInfo);
    }

    /**
     * 增加菜单信息
     *
     * @param menuInfo 菜单entity
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<MenuInfo> addMenuInfo(@RequestBody MenuInfo menuInfo) {
        logger.debug("====>菜肴信息: " + menuInfo.toString());
        menuInfo.setMenuId(menuInfo.getStoreId());
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
        logger.debug("====>菜肴信息: " + menuInfo.toString());
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
        logger.debug("====>菜肴ID: " + dishesId.toString());
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
        logger.debug("====>菜肴ID: " + dishesId.toString());
        return menuInfoService.deleteMenuInfoByIdsService(dishesId);
    }


    /**
     * 通过菜品种类获得菜单信息
     *
     * @param storeId 门店ID
     * @return MenuInfoMobile
     */
    @ResponseBody
    @RequestMapping(value = "/menuInfoByCategory/{storeId}", method = RequestMethod.GET)
    @Override
    public List<MenuInfoMobile> getAllMenuInfoByCategory(@PathVariable("storeId") Long storeId) {

        logger.debug("====>门店ID: " + storeId.toString());
        List<MenuInfoMobile> base = new ArrayList<>();
        /* 获得菜肴种类 */
        List<MenuInfo> listCategory = menuInfoService.getAllMenuInfoByCategory(storeId);

        if (listCategory.size() > 0) {
            logger.debug("====>菜肴种类: " + listCategory.toString());
            for (MenuInfo category : listCategory) {
                MenuInfoMobile menuInfoMobile = new MenuInfoMobile();

                List<String> foot = new ArrayList<>();
                /* 添加菜肴种类 */
                menuInfoMobile.setName(category.getName());

                /* 通过菜肴种类获得菜肴信息 */
                MenuInfo menuInfo = new MenuInfo();
                menuInfo.setDishesCategory(category.getDishesCategory());
                menuInfo.setStoreId(storeId);
                List<MenuInfo> allMenuInfoService = menuInfoService.getAllMenuInfoService(menuInfo);

                /* 计算最新菜价（菜价*折扣）*/
                DecimalFormat df = new DecimalFormat("#.00");
                allMenuInfoService.forEach(x -> x.setDishesPriceNow(df.format(new BigDecimal(x.getDishesPrice() * Double.valueOf(x.getDishesDiscountPrice())))));
                allMenuInfoService.forEach(x -> foot.add(JSON.toJSONString(x)));
                logger.debug("====>菜肴信息: " + foot.toString());
                menuInfoMobile.setFoods(String.valueOf(foot));
                base.add(menuInfoMobile);
            }
        }

        return base;
    }
}
