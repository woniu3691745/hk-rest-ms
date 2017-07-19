package com.team.hk.sys.server.impl;

import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.mapper.SysMenuInfoMapper;
import com.team.hk.sys.server.SysMenuInfoService;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(SysMenuInfoServiceImpl.class);

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

    /**
     * 添加之后查询
     *
     * @param sysMenuInfo 系统菜单实体
     * @return SysMenuInfo
     */
    @Override
    public List<SysMenuInfo> addSysMenuInfoService(SysMenuInfo sysMenuInfo) {
        sysMenuInfoMapper.add(sysMenuInfo);
        if (sysMenuInfo.getId() != null) {
            logger.debug("添加系统菜单信息成功,返回ID : " + sysMenuInfo.getId());
            SysMenuInfo smi = new SysMenuInfo();
            smi.setId(sysMenuInfo.getId());
            return sysMenuInfoMapper.list(smi);
        } else {
            logger.error("添加系统菜单信息失败,返回ID : " + sysMenuInfo.getId());
            return null;
        }
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
