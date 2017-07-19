package com.team.hk.sys.contorller.impl;

import com.team.hk.sys.contorller.SysDictInfoController;
import com.team.hk.sys.entity.SysDictInfo;
import com.team.hk.sys.server.SysDictInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统字典信息实现类
 */
@Controller
@RequestMapping("/api/sysDict")
public class SysDictInfoControllerImpl implements SysDictInfoController {

    private static Logger logger = Logger.getLogger(SysDictInfoControllerImpl.class);

    @Autowired
    private SysDictInfoService sysDictInfoService;

    /**
     * 获得系统字典信息（通过分页）
     *
     * @param sysDictInfo 系统字典entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysDictInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<SysDictInfo> getAllSysDictInfoByPage(@RequestBody SysDictInfo sysDictInfo, @PathVariable("pageNo") Long pageNo,
                                                     @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<SysDictInfo> sysDictInfos = sysDictInfoService.getAllSysDictInfoByPageService(sysDictInfo, pageNo, pageSize);
        int count = sysDictInfoService.getAllSysDictInfoCountByPageService(sysDictInfo, pageNo, pageSize);
        list.add(sysDictInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得系统字典信息
     *
     * @param sysDictInfo 系统字典entity
     * @return List<SysDictInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<SysDictInfo> getAllSysDictInfo(@RequestBody SysDictInfo sysDictInfo) {
        return sysDictInfoService.getAllSysDictInfoService(sysDictInfo);
    }


    /**
     * 增加系统字典信息
     *
     * @param sysDictInfo 系统字典entity
     * @return List<SysDictInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<SysDictInfo> addSysDictInfo(@RequestBody SysDictInfo sysDictInfo) {
        return sysDictInfoService.addSysDictInfoService(sysDictInfo);
    }

    /**
     * 修改系统字典信息
     *
     * @param sysDictInfo 系统字典entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateSysDictInfo(@RequestBody SysDictInfo sysDictInfo) {
        return sysDictInfoService.updateSysDictInfoService(sysDictInfo);
    }

    /**
     * 删除一个系统字典信息
     *
     * @param dictId 系统字典ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{dictId}", method = RequestMethod.DELETE)
    @Override
    public int deleteSysDictInfoById(@PathVariable("dictId") Long dictId) {
        return sysDictInfoService.deleteSysDictInfoByIdService(dictId);
    }

    /**
     * 删除多个系统字典
     *
     * @param dictId 系统字典ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteSysDictInfoByIds(@RequestParam("dictId") List<Long> dictId) {
        return sysDictInfoService.deleteSysDictInfoByIdsService(dictId);
    }
}
