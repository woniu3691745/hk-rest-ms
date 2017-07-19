package com.team.hk.sys.server.impl;

import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.mapper.SysUserInfoMapper;
import com.team.hk.sys.server.SysUserInfoService;
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
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public List<SysUserInfo> getAllSysUserInfoByPageService(SysUserInfo sysUserInfo, Long pageNo, Long pageSize) {
        sysUserInfo.setPageNo(pageNo);
        sysUserInfo.setPageSize(pageSize);
        return sysUserInfoMapper.listByPage(sysUserInfo);
    }

    @Override
    public int getAllSysUserInfoCountByPageService(SysUserInfo sysUserInfo, Long pageNo, Long pageSize) {
        sysUserInfo.setPageNo(pageNo);
        sysUserInfo.setPageSize(pageSize);
        return sysUserInfoMapper.listCountByPage(sysUserInfo);
    }

    @Override
    public List<SysUserInfo> getAllSysUserInfoService(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.list(sysUserInfo);
    }

    /**
     * 添加之后查询
     *
     * @param sysUserInfo 系统用户实体
     * @return SysUserInfo
     */
    @Override
    public List<SysUserInfo> addSysUserInfoService(SysUserInfo sysUserInfo) {
        sysUserInfoMapper.add(sysUserInfo);
        return sysUserInfoMapper.list(sysUserInfo);
    }

    @Override
    public int updateSysUserInfoService(SysUserInfo sysUserInfo) {
        return sysUserInfoMapper.update(sysUserInfo);
    }

    @Override
    public int deleteSysUserInfoByIdService(Long userId) {
        return sysUserInfoMapper.deleteById(userId);
    }

    @Override
    public int deleteSysUserInfoByIdsService(List<Long> userId) {
        return sysUserInfoMapper.deleteByIds(userId);
    }
}
