package com.team.hk.common;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/4.
 * common方法
 */
public interface CommonMapper<T> {

    /**
     * 获得全部数据（分页）
     *
     * @return List<T>
     */
    List<T> listByPage(T t);

    /**
     * 获得全部数据数量
     *
     * @return List<T>
     */
    int listCountByPage(T t);

    /**
     * 获得全部数据
     *
     * @return List<T>
     */
    List<T> list(T t);

    /**
     * 获得全部数据（不带参数)
     *
     * @return List<T>
     */
    List<T> list();

    /**
     * 获得全部数据（id）
     *
     * @return List<T>
     */
    List<T> list(Long id);

    /**
     * 更新
     *
     * @param t 实体
     * @return rowsAffected
     */
    int update(T t);

    /**
     * 删除一条
     *
     * @param id 标识
     * @return rowsAffected
     */
    int deleteById(Long id);

    /**
     * 删除多条
     *
     * @param t 实体
     * @return rowsAffected
     */
    int deleteByIds(T t);

    /**
     * 增加
     *
     * @param t 实体
     */
    int add(T t);
}


