package com.team.hk.sys.server.impl;

import com.team.hk.sys.entity.SysDictInfo;
import com.team.hk.sys.mapper.SysDictInfoMapper;
import com.team.hk.sys.server.SysDictInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统字典信息Service实现类
 */
@Transactional
@Service
public class SysDictInfoServiceImpl implements SysDictInfoService {

    private static Logger logger = Logger.getLogger(SysDictInfoServiceImpl.class);

    @Autowired
    private SysDictInfoMapper sysDictInfoMapper;

    @Override
    public List<SysDictInfo> getAllSysDictInfoByPageService(SysDictInfo sysDictInfo, Long pageNo, Long pageSize) {
        sysDictInfo.setPageNo(pageNo);
        sysDictInfo.setPageSize(pageSize);
        return sysDictInfoMapper.listByPage(sysDictInfo);
    }

    @Override
    public int getAllSysDictInfoCountByPageService(SysDictInfo sysDictInfo, Long pageNo, Long pageSize) {
        sysDictInfo.setPageNo(pageNo);
        sysDictInfo.setPageSize(pageSize);
        return sysDictInfoMapper.listCountByPage(sysDictInfo);
    }

    @Override
    public List<SysDictInfo> getAllSysDictInfoService(SysDictInfo sysDictInfo) {
        return sysDictInfoMapper.list(sysDictInfo);
    }

    @Override
    public List<SysDictInfo> addSysDictInfoService(SysDictInfo sysDictInfo) {
//        sysDictInfoMapper.add(sysDictInfo);
        if (sysDictInfo.getId() != null) {
            logger.debug("添加系统字典信息成功,返回ID : " + sysDictInfo.getId());
            SysDictInfo sdi = new SysDictInfo();
            sdi.setId(sysDictInfo.getId());
            return sysDictInfoMapper.list(sysDictInfo);
        } else {
            logger.error("添加系统字典信息失败,返回ID : " + sysDictInfo.getId());
            return null;
        }
    }

    @Override
    public int updateSysDictInfoService(SysDictInfo sysDictInfo) {
        return sysDictInfoMapper.update(sysDictInfo);
    }

    @Override
    public int deleteSysDictInfoByIdService(Long dictId) {
        return sysDictInfoMapper.deleteById(dictId);
    }

    @Override
    public int deleteSysDictInfoByIdsService(List<Long> dictId) {
        return sysDictInfoMapper.deleteByIds(dictId);
    }
}
