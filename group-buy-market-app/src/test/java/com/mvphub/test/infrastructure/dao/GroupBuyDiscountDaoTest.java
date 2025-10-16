package com.mvphub.test.infrastructure.dao;


import com.alibaba.fastjson2.JSON;
import com.mvphub.infrastructure.dao.IGroupBuyDiscountDao;
import com.mvphub.infrastructure.dao.po.GroupBuyDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyDiscountDaoTest {

    @Resource
    private IGroupBuyDiscountDao iGroupBuyDiscountDao;

    @Test
    public void testQueryActivityList() {
        List<GroupBuyDiscount> groupBuyDiscounts = iGroupBuyDiscountDao.queryGroupBuyDiscountList();
        log.info("测试结果：{}", JSON.toJSONString(groupBuyDiscounts));
    }
}
