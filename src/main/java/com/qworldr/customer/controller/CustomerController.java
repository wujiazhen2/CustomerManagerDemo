package com.qworldr.customer.controller;

import com.qworld.query.QueryParam;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/save")
    public ResponseEntity saveCustomer(CustomerEntitiy customerEntitiy){
        customerService.saveCustomer(customerEntitiy);
        return ResponseEntity.ok().build();
    }
    @RequestMapping("/update")
    public ResponseEntity update(CustomerEntitiy customerEntitiy){
        customerService.updateCusomter(customerEntitiy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerEntitiy>> list(QueryParam queryParam){
        List<CustomerEntitiy> list = customerService.list(queryParam);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntitiy> get(@PathVariable int id){
        CustomerEntitiy customerEntitiy=customerService.get(id);
        return ResponseEntity.ok(customerEntitiy);
    }
}
