package com.team.hk.tableInfo.controller.impl;

import com.team.hk.tableInfo.controller.TableInfoController;
import com.team.hk.tableInfo.entity.TableInfo;
import com.team.hk.tableInfo.service.TableInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息实现类
 */
@Controller
@RequestMapping("/api/table")
public class TableInfoControllerImpl implements TableInfoController {

    private static Logger logger = Logger.getLogger(TableInfoControllerImpl.class);

    @Autowired
    private TableInfoService tableInfoService;

    /**
     * 获得桌子信息（通过分页）
     *
     * @param tableInfo 桌子entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<TableInfo> getAllTableInfoByPage(@RequestBody TableInfo tableInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<TableInfo> tableInfos = tableInfoService.getAllTableInfoByPageService(tableInfo, pageNo, pageSize);
        int count = tableInfoService.getAllTableInfoCountByPageService(tableInfo, pageNo, pageSize);
        list.add(tableInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得桌子信息
     *
     * @param tableInfo 桌子entity
     * @return List<TableInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<TableInfo> getAllTableInfo(@RequestBody TableInfo tableInfo) {
        return tableInfoService.getAllTableInfoService(tableInfo);
    }

    /**
     * 增加桌子信息
     *
     * @param tableInfo 门店entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addTableInfo(@RequestBody TableInfo tableInfo) {
        return tableInfoService.addTableInfoService(tableInfo);
    }

    /**
     * 修改桌子信息
     *
     * @param tableInfo 门店entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateTableInfo(@RequestBody TableInfo tableInfo) {
        return tableInfoService.updateTableInfoService(tableInfo);
    }

    /**
     * 删除一个桌子
     *
     * @param tableId 桌子ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{tableId}", method = RequestMethod.DELETE)
    @Override
    public int deleteTableInfoById(@PathVariable("tableId") Long tableId) {
        return tableInfoService.deleteTableInfoByIdService(tableId);
    }

    /**
     * 删除多个桌子
     *
     * @param tableId 桌子ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteTableInfoByIds(@RequestParam("tableId") List<Long> tableId) {
        return tableInfoService.deleteTableInfoByIdsService(tableId);
    }

}
