package com.qworldr.customer.controller;

import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    public ResponseEntity saveCustomer(CustomerEntitiy customerEntitiy){
        customerService.saveCustomer(customerEntitiy);
        return null;
    }
}
