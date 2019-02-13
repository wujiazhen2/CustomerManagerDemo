package com.qworldr.customer.service;

import com.qworldr.query.QueryParam;
import com.qworldr.customer.generator.bean.CustomerEntitiy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
public interface CustomerService {

    CustomerEntitiy saveCustomer(CustomerEntitiy customerEntitiy);

    void updateCusomter(CustomerEntitiy customerEntitiy);

    void delete(ArrayList<Integer> id);

    List<CustomerEntitiy> list(QueryParam queryParam);

    CustomerEntitiy get(int id);
}
