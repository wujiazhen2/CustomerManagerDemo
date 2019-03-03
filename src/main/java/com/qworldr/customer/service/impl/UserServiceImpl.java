package com.qworldr.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qworldr.customer.bean.CustomerEntitiy;
import com.qworldr.customer.bean.UserEntitiy;
import com.qworldr.customer.query.QueryParam;
import com.qworldr.customer.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wujiazhen
 * @date 2019/2/24
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntitiy,Integer> implements UserService {


    @Override
    protected QueryWrapper<UserEntitiy> createQueryWrapper(QueryParam queryParam) {
        QueryWrapper<UserEntitiy> queryWrapper = super.createQueryWrapper(queryParam);
        if (StringUtils.isNotBlank(queryParam.getSearchText())) {
            queryWrapper.likeRight("name", queryParam.getSearchText());
        }
        return queryWrapper;
    }
}
