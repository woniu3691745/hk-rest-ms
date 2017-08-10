package com.team.hk.storeInfo.service.impl;

import com.team.hk.storeInfo.entity.StoreImg;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.entity.StoreUserInfo;
import com.team.hk.storeInfo.mapper.StoreInfoMapper;
import com.team.hk.storeInfo.service.StoreInfoService;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
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

    @Autowired
    private StoreInfoMapper storeInfoMapper;

    private String url = "api/store/storeImgDown/";

    @Override
    public List<StoreInfo> getAllStoreInfoByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize) {
        storeInfo.setPageNo(pageNo);
        storeInfo.setPageSize(pageSize);
        return storeInfoMapper.listByPage(storeInfo);
    }

    @Override
    public int getAllStoreInfoCountByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize) {
        storeInfo.setPageNo(pageNo);
        storeInfo.setPageSize(pageSize);
        return storeInfoMapper.listCountByPage(storeInfo);
    }

    @Override
    public List<StoreInfo> getAllStoreInfoService(StoreInfo storeInfo) {
        return storeInfoMapper.list(storeInfo);
    }

    /**
     * 1.保门店信息
     * 2.保存门店,用户关联信息
     * 3.保存门店图片信息
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    @Override
    public List<StoreInfo> addStoreInfoService(StoreInfo storeInfo) {

        int baseInfo = storeInfoMapper.add(storeInfo);
        logger.debug("====> 门店基本信息保存成功!:" + baseInfo);

        // 保存门店用户关联信息
        StoreUserInfo storeUserInfo = new StoreUserInfo();
        storeUserInfo.setUserId(storeInfo.getUserId());
        storeUserInfo.setStoreId(storeInfo.getStoreId());
        if (baseInfo != 0) {
            storeInfoMapper.addStoreUserInfo(storeUserInfo);
            logger.debug("====> 门店信息用户关联信息保存成功!:");
            // 保存门店图片
            List<StoreImg> storeImgList = new ArrayList<>();
            for (String img : storeInfo.getStoreImg()) {
                StoreImg storeImg = new StoreImg();
                storeImg.setStoreId(storeInfo.getStoreId());
                storeImg.setImgUrl(this.url + storeInfo.getPath() + "/" + img);
                storeImgList.add(storeImg);
            }
            storeInfoMapper.addStoreImg(storeImgList);
            logger.debug("====> 保存门店图片路径:" + storeImgList.toString());
        }

        if (storeInfo.getStoreId() != null) {
            StoreInfo sif = new StoreInfo();
            sif.setStoreId(storeInfo.getStoreId());
            logger.debug("====> 添加门店信息成功,返回STOREID : " + storeInfo.getStoreId());
            return storeInfoMapper.list(sif);
        } else {
            logger.error("====> 添加门店信息失败,返回STOREID : " + storeInfo.getStoreId());
            return null;
        }
    }

    /**
     * 1.更新门店信息
     * 2.更新门店图片
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    @Override
    public int updateStoreInfoService(StoreInfo storeInfo) {
        int num = storeInfoMapper.update(storeInfo);
        logger.debug("====> 更新门店信息成功!");
        List<StoreImg> storeImgList = new ArrayList<>();

        for (String img : storeInfo.getStoreImg()) {
            // 去掉已经存在的图片
            if (img.contains(".")) {
                StoreImg storeImg = new StoreImg();
                storeImg.setStoreId(storeInfo.getStoreId());
                storeImg.setImgUrl(this.url + storeInfo.getPath() + "/" + img);
                storeImgList.add(storeImg);
            }
        }
        if (num != 0 && storeImgList.size() != 0) {
            storeInfoMapper.addStoreImg(storeImgList);
//            storeInfoMapper.updateStoreImg(storeImgList);
            logger.debug("====> 更新门店图片信息成功!");
        }
        return num;
    }

    /**
     * 删除 HK_STORE_INFO_T HK_USER_STORE_INFO_T 一条数据
     *
     * @param storeId 门店ID
     * @return rowsAffected
     */
    @Override
    public int deleteStoreInfoByIdService(Long storeId) {
        storeInfoMapper.deleteByIdOne(storeId);
        return storeInfoMapper.deleteById(storeId);
    }

    /**
     * 删除 HK_STORE_INFO_T HK_USER_STORE_INFO_T 多条数据
     *
     * @param storeId 门店ID
     * @return rowsAffected
     */
    @Override
    public int deleteStoreInfoByIdsService(List<Long> storeId) {
        storeInfoMapper.deleteByIdsOne(storeId);
        return storeInfoMapper.deleteByIds(storeId);
    }

    /**
     * 通过用户ID获得门店ID
     *
     * @param id 用户ID
     * @return 门店ID
     */
    @Override
    public Long getStoreIdbyUser(Long id) {
        return storeInfoMapper.getStoreIdbyUser(id);
    }

    /**
     * 获得门店图片
     *
     * @param id 门店ID
     * @return 门店图片
     */
    @Override
    public List<String> getStoreImg(Long id) {
        return storeInfoMapper.getStoreImg(id);
    }

    /**
     * 删除门店图片
     *
     * @param storeImg 门店图片
     * @return rowsAffected
     */
    @Override
    public int deleteStoreImg(StoreImg storeImg) {
        return storeInfoMapper.deleteStoreImg(storeImg);
    }
}
