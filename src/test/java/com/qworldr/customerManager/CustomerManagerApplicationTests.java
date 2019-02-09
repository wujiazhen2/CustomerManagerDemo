package com.qworldr.customerManager;

import com.qworldr.query.QueryParam;
import com.qworldr.customer.CustomerManagerApplication;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerManagerApplication.class)
public class CustomerManagerApplicationTests {
	@Autowired
	private CustomerService customerService;
	@Test
	public void contextLoads() {
        for(int i=0;i<10;i++) {
            CustomerEntitiy customerEntitiy = new CustomerEntitiy();
            customerEntitiy.setName("wujiazhen"+i);
            customerService.saveCustomer(customerEntitiy);
        }
	}

    @Test
    public void select() {
        QueryParam queryParam=new QueryParam();
        queryParam.setPageNum(2);
        queryParam.setPageSize(3);
        List<CustomerEntitiy> list = customerService.list(queryParam);
        for (CustomerEntitiy customerEntitiy : list) {
            System.out.println(customerEntitiy.getName());
        }
    }



}

