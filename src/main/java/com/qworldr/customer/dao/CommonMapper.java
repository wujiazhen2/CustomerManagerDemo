package com.qworldr.customer.dao;

import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
     @Select("select max(id) from t_customer")
     Integer selectMaxCustomerKey();
}
