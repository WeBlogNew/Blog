package com.threeFarmer.dao.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础DAO接口
 */
public interface IBaseDao<T> {

    T findById(@Param("id") Integer id);

    int save(T entity);

    int update(T entity);

    int delete(@Param("id") Integer id);

    List<T> allList();
}
