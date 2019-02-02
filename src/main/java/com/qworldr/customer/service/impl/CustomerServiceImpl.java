package com.qworldr.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qworld.query.QueryParam;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.generator.bean.CustomerEntitiyExample;
import com.qworldr.customer.generator.dao.CustomerEntitiyMapper;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerEntitiyMapper customerEntitiyMapper;
    @Override
    public CustomerEntitiy saveCustomer(CustomerEntitiy customerEntitiy) {
        customerEntitiy.setDeleteflag(false);
        customerEntitiyMapper.insert(customerEntitiy);
        return customerEntitiy;
    }

    @Override
    public void updateCusomter(CustomerEntitiy customerEntitiy) {
        customerEntitiyMapper.updateByPrimaryKeySelective(customerEntitiy);
    }

    @Override
    public void delete(int id) {
        CustomerEntitiy customerEntitiy = new CustomerEntitiy();
        customerEntitiy.setId(id);
        customerEntitiy.setDeleteflag(true);
        customerEntitiy.setDeletetime((int)(System.currentTimeMillis()/1000));
        customerEntitiyMapper.updateByPrimaryKey(customerEntitiy);
    }

    @Override
    public List<CustomerEntitiy> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(),queryParam.getPageSize());
        CustomerEntitiyExample example = new CustomerEntitiyExample();
        example.createCriteria().andDeleteflagEqualTo(Boolean.FALSE);
        List<CustomerEntitiy> customerEntitiys = customerEntitiyMapper.selectByExample(example);
        return customerEntitiys;
    }

    @Override
    public CustomerEntitiy get(int id) {
        return customerEntitiyMapper.selectByPrimaryKey(id);
    }
}
