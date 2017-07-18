package com.team.hk.storeInfo.controller.impl;

import com.team.hk.storeInfo.controller.StoreInfoController;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.service.StoreInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获得门店信息（通过分页）
     *
     * @param storeInfo 门店entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @Override
    public List<StoreInfo> getAllStoreInfoByPage(@RequestBody StoreInfo storeInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<StoreInfo> menuInfos = storeInfoService.getAllStoreInfoByPageService(storeInfo, pageNo, pageSize);
        int count = storeInfoService.getAllStoreInfoCountByPageService(storeInfo, pageNo, pageSize);
        list.add(menuInfos);
        list.add(count);
        logger.debug("storeInfo --------- " + storeInfo.toString());
        return list;
    }

    /**
     * 获得门店信息
     *
     * @param storeId 门店ID
     * @return List<StoreInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get/{storeId}", method = RequestMethod.GET)
    @Override
    public List<StoreInfo> getAllStoreInfo(@PathVariable("storeId") Long storeId) {
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreId(storeId);
        List<StoreInfo> storeInfos = storeInfoService.getAllStoreInfoService(storeInfo);
        return storeInfos;
    }

    /**
     * 增加门店信息
     *
     * @param storeInfo 门店entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addStoreInfo(@RequestBody StoreInfo storeInfo) {
        int i = storeInfoService.addStoreInfoService(storeInfo);
        return i;
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
        int i = storeInfoService.updateStoreInfoService(storeInfo);
        return i;
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
        int i = storeInfoService.deleteStoreInfoByIdService(storeId);
        return i;
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
        int i = storeInfoService.deleteStoreInfoByIdsService(storeId);
        return i;
    }
}
