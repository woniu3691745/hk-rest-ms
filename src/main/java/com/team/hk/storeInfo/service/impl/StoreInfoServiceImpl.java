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
    public List<StoreInfo> addStoreInfoService(StoreInfo storeInfo) {
        storeInfoMapper.add(storeInfo);
        if (storeInfo.getStoreId() != null) {
            logger.debug("添加门店信息成功,返回ID : " + storeInfo.getStoreId());
            StoreInfo sif = new StoreInfo();
            sif.setStoreId(storeInfo.getStoreId());
            return storeInfoMapper.list(sif);
        } else {
            logger.error("添加门店信息失败,返回ID : " + storeInfo.getStoreId());
            return null;
        }
    }

    @Override
    public int updateStoreInfoService(StoreInfo storeInfo) {
        return storeInfoMapper.update(storeInfo);
    }

    @Override
    public int deleteStoreInfoByIdService(Long storeId) {
        return storeInfoMapper.deleteById(storeId);
    }

    @Override
    public int deleteStoreInfoByIdsService(List<Long> storeId) {
        return storeInfoMapper.deleteByIds(storeId);
    }
}
