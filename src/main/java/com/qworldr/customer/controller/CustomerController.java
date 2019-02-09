package com.qworldr.customer.controller;

import com.qworldr.query.QueryParam;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Integer> saveCustomer(@RequestBody CustomerEntitiy customerEntitiy){
        customerService.saveCustomer(customerEntitiy);
        return ResponseEntity.ok(customerEntitiy.getId());
    }
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody CustomerEntitiy customerEntitiy){
        customerService.updateCusomter(customerEntitiy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/list")
    public ResponseEntity<List<CustomerEntitiy>> list(@RequestBody  QueryParam queryParam){
        List<CustomerEntitiy> list = customerService.list(queryParam);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntitiy> get(@PathVariable int id){
        CustomerEntitiy customerEntitiy=customerService.get(id);
        return ResponseEntity.ok(customerEntitiy);
    }
}
