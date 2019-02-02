package com.qworldr.customer.service.impl;

import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.generator.dao.CustomerEntitiyMapper;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerEntitiyMapper customerEntitiyMapper;
    @Override
    public void saveCustomer(CustomerEntitiy customerEntitiy) {
        customerEntitiyMapper.insert(customerEntitiy);
    }
}
