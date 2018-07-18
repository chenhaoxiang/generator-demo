/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.common;

/**
 * 所有数据库持久化操作超类
 *
 * @author chenhx
 * @version BaseMapping.java, v 0.1 2018-07-17 下午 4:37
 */
public interface BaseMapper<T> {
    /**
     * 根据ID查询数据
     *
     * @param id 实体类的ID
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 执行完全插入操作 也就是不能有null值
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 执行部分插入操作 也就是null值不插入
     *
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 执行更新操作 全部更新
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     * 执行部分更新操作 为null的不会被插入
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);

    /**
     * 真正意义上的删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

}
