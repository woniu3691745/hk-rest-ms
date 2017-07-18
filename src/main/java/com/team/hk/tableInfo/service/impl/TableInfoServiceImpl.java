package com.team.hk.tableInfo.service.impl;

import com.team.hk.tableInfo.entity.TableInfo;
import com.team.hk.tableInfo.mapper.TableInfoMapper;
import com.team.hk.tableInfo.service.TableInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息Service实现类
 */
@Transactional
@Service
public class TableInfoServiceImpl implements TableInfoService {

    private static Logger logger = Logger.getLogger(TableInfoServiceImpl.class);

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Override
    public List<TableInfo> getAllTableInfoByPageService(TableInfo tableInfo, Long pageNo, Long pageSize) {
        tableInfo.setPageNo(pageNo);
        tableInfo.setPageSize(pageSize);
        return tableInfoMapper.listByPage(tableInfo);
    }

    @Override
    public int getAllTableInfoCountByPageService(TableInfo tableInfo, Long pageNo, Long pageSize) {
        tableInfo.setPageNo(pageNo);
        tableInfo.setPageSize(pageSize);
        return tableInfoMapper.listCountByPage(tableInfo);
    }

    @Override
    public List<TableInfo> getAllTableInfoService(TableInfo tableInfo) {
        return tableInfoMapper.list(tableInfo);
    }

    @Override
    public int addTableInfoService(TableInfo tableInfo) {
        return tableInfoMapper.add(tableInfo);
    }

    @Override
    public int updateTableInfoService(TableInfo tableInfo) {
        return tableInfoMapper.update(tableInfo);
    }

    @Override
    public int deleteTableInfoByIdService(Long tableId) {
        return tableInfoMapper.deleteById(tableId);
    }

    @Override
    public int deleteTableInfoByIdsService(List<Long> tableId) {
        return tableInfoMapper.deleteByIds(tableId);
    }
}
