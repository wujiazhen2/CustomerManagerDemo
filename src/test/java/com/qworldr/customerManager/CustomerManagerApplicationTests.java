package com.qworldr.customerManager;

import com.qworldr.customer.CustomerManagerApplication;
import com.qworldr.customer.generator.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerManagerApplication.class)
public class CustomerManagerApplicationTests {
	@Autowired
	private CustomerService customerService;
	@Test
	public void contextLoads() {
		CustomerEntitiy customerEntitiy = new CustomerEntitiy();
		customerEntitiy.setName("wujiazhen");
		customerService.saveCustomer(customerEntitiy);
	}

    @Test
    public void select() {
        CustomerEntitiy customerEntitiy = new CustomerEntitiy();
        customerEntitiy.setName("wujiazhen");
        customerService.saveCustomer(customerEntitiy);
    }

}

