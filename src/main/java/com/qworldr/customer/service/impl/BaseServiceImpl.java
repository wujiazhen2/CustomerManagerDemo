package com.qworldr.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.qworldr.customer.bean.AbstractEntity;
import com.qworldr.customer.query.QueryParam;
import com.qworldr.customer.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author wujiazhen
 * @date 2019/3/3
 */
public abstract class BaseServiceImpl<T extends AbstractEntity, K extends Serializable> implements BaseService<T, K> {
    private final static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    @Autowired
    private BaseMapper<T> mapper;

    private Class<T> clazz;

    public BaseServiceImpl() {
        ResolvableType resolvableType = ResolvableType.forClass(this.getClass());
        ResolvableType[] interfaces = resolvableType.getInterfaces();
        clazz = (Class<T>) interfaces[0].getGeneric(0).resolve();
    }

    @Override
    public void save(T entity) {
        entity.setCreatetime(LocalDateTime.now());
        mapper.insert(entity);
    }

    @Override
    public void update(T entity) {
        mapper.updateById(entity);
    }

    @Override
    public void delete(List<K> ids) {
        mapper.deleteBatchIds(ids);
    }

    @Override
    public List<T> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        return mapper.selectList(createQueryWrapper(queryParam));
    }

    protected QueryWrapper<T> createQueryWrapper(QueryParam queryParam) {
        return new QueryWrapper<T>().eq("deleteflag", Boolean.FALSE);
    }

    @Override
    public T get(K id) {
        return mapper.selectById(id);
    }

    @Override
    public void logicDelete(List<K> ids) {
        T t;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(String.format("%s类实例化异常", clazz.getName()), e);
            throw new RuntimeException(e);
        }
        t.setDeleteflag(true);
        t.setDeletetime(LocalDateTime.now());
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>().in("id", ids);
        mapper.update(t, queryWrapper);
    }
}
