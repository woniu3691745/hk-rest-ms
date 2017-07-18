package com.team.hk.storeInfo.service.impl;

import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.mapper.StoreInfoMapper;
import com.team.hk.storeInfo.service.StoreInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息Service实现类
 */
@Transactional
@Service
public class StoreInfoServiceImpl implements StoreInfoService {

    private static Logger logger = Logger.getLogger(StoreInfoServiceImpl.class);

    private final String KEY_PREFIX = "store_";

    @Autowired
    private StoreInfoMapper storeInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<StoreInfo> getAllStoreInfoByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize) {
        storeInfo.setPageNo(pageNo);
        storeInfo.setPageSize(pageSize);
        List storeInfoListByPage = storeInfoMapper.listByPage(storeInfo);
        return storeInfoListByPage;
    }

    @Override
    public int getAllStoreInfoCountByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize) {
        storeInfo.setPageNo(pageNo);
        storeInfo.setPageSize(pageSize);
        int count = storeInfoMapper.listCountByPage(storeInfo);
        return count;
    }

    @Override
    public List<StoreInfo> getAllStoreInfoService(StoreInfo storeInfo) {
//        ListOperations valueOperations = redisTemplate.opsForList();
//        String key = KEY_PREFIX + storeInfo.getStoreId();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            List storeInfos = new ArrayList();
//            storeInfos.add(valueOperations.getOperations());
//            return storeInfos;
//        }
        List<StoreInfo> storeInfos = storeInfoMapper.list(storeInfo);
//        valueOperations.set(key, 0, storeInfos);
        return storeInfos;
    }

    @Override
    public int addStoreInfoService(StoreInfo storeInfo) {
        int i = storeInfoMapper.add(storeInfo);
        return i;
    }

    @Override
    public int updateStoreInfoService(StoreInfo storeInfo) {
        int i = storeInfoMapper.update(storeInfo);
        return i;
    }

    @Override
    public int deleteStoreInfoByIdService(Long storeId) {
        int i = storeInfoMapper.deleteById(storeId);
        return i;
    }

    @Override
    public int deleteStoreInfoByIdsService(List<Long> storeId) {
        int i = storeInfoMapper.deleteByIds(storeId);
        return i;
    }
}
