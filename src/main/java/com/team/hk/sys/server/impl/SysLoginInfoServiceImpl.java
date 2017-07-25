package com.team.hk.sys.server.impl;

import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.mapper.SysLoginInfoMapper;
import com.team.hk.sys.server.SysLoginInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lidongliang on 2017/7/25.
 * 系统登录Service实现类
 */
@Transactional
@Service
public class SysLoginInfoServiceImpl implements SysLoginInfoService {

    private static Logger logger = Logger.getLogger(SysLoginInfoServiceImpl.class);

    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;

    @Override
    public SysUserInfo login(SysUserInfo sysUserInfo) {
        return sysLoginInfoMapper.login(sysUserInfo);
    }
}
