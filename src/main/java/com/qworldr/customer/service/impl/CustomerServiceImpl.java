package com.qworldr.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qworldr.customer.dao.CommonMapper;
import com.qworldr.query.QueryParam;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.generator.bean.CustomerEntitiyExample;
import com.qworldr.customer.generator.dao.CustomerEntitiyMapper;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerEntitiyMapper customerEntitiyMapper;
    @Autowired
    private CommonMapper commonMapper;
    private AtomicInteger id=new AtomicInteger(0);
    @PostConstruct
    public void init(){
        //查询最大的
        Integer key = commonMapper.selectMaxCustomerKey();
        if(key>0){
            id=new AtomicInteger(key);
        }
    }
    @Override
    public CustomerEntitiy saveCustomer(CustomerEntitiy customerEntitiy) {
        customerEntitiy.setDeleteflag(false);
        customerEntitiy.setId(id.incrementAndGet());
        customerEntitiyMapper.insertSelective(customerEntitiy);
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
        example.createCriteria().andDeleteflagEqualTo(Boolean.FALSE).andNameLike(queryParam.getSearchText()+"%");
        List<CustomerEntitiy> customerEntitiys = customerEntitiyMapper.selectByExample(example);
        return customerEntitiys;
    }

    @Override
    public CustomerEntitiy get(int id) {
        return customerEntitiyMapper.selectByPrimaryKey(id);
    }
}
