package com.qworldr.customer.service;

import com.qworldr.customer.bean.AbstractEntity;
import com.qworldr.customer.query.QueryParam;

import java.io.Serializable;
import java.util.List;

/**
 * @author wujiazhen
 * @date 2019/3/3
 */
public interface BaseService<T extends AbstractEntity,K extends Serializable> {
    void save(T entity);

    void update(T entity);

    void delete(List<K> ids);

    List<T> list(QueryParam queryParam);

    T get(K id);

    /**
     * 逻辑删除
     * @param ids 逻辑删除的主键
     */
    void logicDelete(List<K> ids);
}
