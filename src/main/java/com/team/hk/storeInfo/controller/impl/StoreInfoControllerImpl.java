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
}
