package com.team.hk.sys.server.impl;

import com.team.hk.storeInfo.entity.StoreUserInfo;
import com.team.hk.storeInfo.mapper.StoreInfoMapper;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.mapper.SysUserInfoMapper;
import com.team.hk.sys.server.SysUserInfoService;
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
public class SysUserInfoServiceImpl implements SysUserInfoService {

    private static Logger logger = Logger.getLogger(SysUserInfoServiceImpl.class);

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Autowired
    private StoreInfoMapper storeInfoMapper;

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

        /* 保存用户信息 */
        sysUserInfoMapper.add(sysUserInfo);

        /* 保存用户和门店关系信息,仅user用户 */
        if (sysUserInfo.getStoreId() != null) {
            StoreUserInfo storeUserInfo = new StoreUserInfo();
            storeUserInfo.setUserId(sysUserInfo.getUserId());
            storeUserInfo.setStoreId(sysUserInfo.getStoreId());
            storeInfoMapper.addStoreUserInfo(storeUserInfo);
        }

        if (sysUserInfo.getUserId() != null) {
            logger.debug("添加系统用户信息成功,返回USER_ID : " + sysUserInfo.getUserId());
            SysUserInfo sui = new SysUserInfo();
            sui.setUserId(sysUserInfo.getUserId());
            return sysUserInfoMapper.list(sui);
        } else {
            logger.error("添加系统用户信息失败,返回USER_ID : " + sysUserInfo.getUserId());
            return null;
        }
    }

    @Override
    public int updateSysUserInfoService(SysUserInfo sysUserInfo) {

        /* 更新用户和门店关系信息 */
        StoreUserInfo storeUserInfo = new StoreUserInfo();
        storeUserInfo.setUserId(sysUserInfo.getUserId());
        storeUserInfo.setStoreId(sysUserInfo.getStoreId());
        storeInfoMapper.updateStoreIdByUser(storeUserInfo);

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
