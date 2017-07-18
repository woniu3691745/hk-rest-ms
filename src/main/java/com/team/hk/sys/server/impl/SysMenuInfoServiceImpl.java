package com.team.hk.sys.server.impl;

import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.mapper.SysMenuInfoMapper;
import com.team.hk.sys.server.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单信息Service实现类
 */
@Transactional
@Service
public class SysMenuInfoServiceImpl implements SysMenuInfoService {

    @Autowired
    private SysMenuInfoMapper sysMenuInfoMapper;

    @Override
    public List<SysMenuInfo> getAllSysMenuInfoByPageService(SysMenuInfo sysMenuInfo, Long pageNo, Long pageSize) {
        sysMenuInfo.setPageNo(pageNo);
        sysMenuInfo.setPageSize(pageSize);
        return sysMenuInfoMapper.listByPage(sysMenuInfo);
    }

    @Override
    public int getAllSysMenuInfoCountByPageService(SysMenuInfo sysMenuInfo, Long pageNo, Long pageSize) {
        sysMenuInfo.setPageNo(pageNo);
        sysMenuInfo.setPageSize(pageSize);
        return sysMenuInfoMapper.listCountByPage(sysMenuInfo);
    }

    @Override
    public List<SysMenuInfo> getAllSysMenuInfoService(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.list(sysMenuInfo);
    }

    @Override
    public int addSysMenuInfoService(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.add(sysMenuInfo);
    }

    @Override
    public int updateSysMenuInfoService(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.update(sysMenuInfo);
    }

    @Override
    public int deleteSysMenuInfoByIdService(Long sysMenuId) {
        return sysMenuInfoMapper.deleteById(sysMenuId);
    }

    @Override
    public int deleteSysMenuInfoByIdsService(List<Long> sysMenuId) {
        return sysMenuInfoMapper.deleteByIds(sysMenuId);
    }
}
