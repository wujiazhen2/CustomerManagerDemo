package com.qworldr.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qworldr.customer.bean.CustomerEntitiy;
import com.qworldr.customer.query.QueryParam;
import com.qworldr.customer.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wujiazhen
 * @date 2019/2/2
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerEntitiy, Integer> implements CustomerService {


    @Override
    protected QueryWrapper<CustomerEntitiy> createQueryWrapper(QueryParam queryParam) {
        QueryWrapper<CustomerEntitiy> queryWrapper = super.createQueryWrapper(queryParam);
        if (StringUtils.isNotBlank(queryParam.getSearchText())) {
            queryWrapper.likeRight("name", queryParam.getSearchText());
        }
        return queryWrapper;
    }
}
