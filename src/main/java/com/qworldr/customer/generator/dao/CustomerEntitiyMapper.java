package com.qworldr.customer.generator.dao;

import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.generator.bean.CustomerEntitiyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerEntitiyMapper {
    long countByExample(CustomerEntitiyExample example);

    int deleteByExample(CustomerEntitiyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerEntitiy record);

    int insertSelective(CustomerEntitiy record);

    List<CustomerEntitiy> selectByExample(CustomerEntitiyExample example);

    CustomerEntitiy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerEntitiy record, @Param("example") CustomerEntitiyExample example);

    int updateByExample(@Param("record") CustomerEntitiy record, @Param("example") CustomerEntitiyExample example);

    int updateByPrimaryKeySelective(CustomerEntitiy record);

    int updateByPrimaryKey(CustomerEntitiy record);
}