package com.team.hk.menuInfo.service.impl;

import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.menuInfo.mapper.MenuInfoMapper;
import com.team.hk.menuInfo.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息Service实现类
 */
@Transactional
@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    private static Logger logger = Logger.getLogger(MenuInfoServiceImpl.class);

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Override
    public List<MenuInfo> getAllMenuInfoByPageService(MenuInfo menuInfo, Long pageNo, Long pageSize) {
        menuInfo.setPageNo(pageNo);
        menuInfo.setPageSize(pageSize);
        return menuInfoMapper.listByPage(menuInfo);
    }

    @Override
    public int getAllMenuInfoCountByPageService(MenuInfo menuInfo, Long pageNo, Long pageSize) {
        menuInfo.setPageNo(pageNo);
        menuInfo.setPageSize(pageSize);
        return menuInfoMapper.listCountByPage(menuInfo);
    }

    @Override
    public List<MenuInfo> getAllMenuInfoService(MenuInfo menuInfo) {
        return menuInfoMapper.list(menuInfo);
    }

    @Override
    public int addMenuInfoService(MenuInfo menuInfo) {
        return menuInfoMapper.add(menuInfo);
    }

    @Override
    public int updateMenuInfoService(MenuInfo menuInfo) {
        return menuInfoMapper.update(menuInfo);
    }

    @Override
    public int deleteMenuInfoByIdService(Long dishesId) {
        return menuInfoMapper.deleteById(dishesId);
    }

    @Override
    public int deleteMenuInfoByIdsService(List<Long> dishesId) {
        return menuInfoMapper.deleteByIds(dishesId);
    }
}
