package com.mvphub.test.infrastructure.dao;


import com.alibaba.fastjson2.JSON;
import com.mvphub.infrastructure.dao.IGroupBuyActivityDao;
import com.mvphub.infrastructure.dao.po.GroupBuyActivity;
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
public class GroupBuyActivityDaoTest {

    @Resource
    private IGroupBuyActivityDao iGroupBuyActivityDao;

    @Test
    public void testQueryActivityList() {
        List<GroupBuyActivity> groupBuyActivities = iGroupBuyActivityDao.queryGroupBuyActivityList();
        log.info("测试结果：{}", JSON.toJSONString(groupBuyActivities));
    }
}
