package com.mvphub.test.domain.activity;


import com.alibaba.fastjson2.JSON;
import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.service.trail.IIndexGroupBuyMarketService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IIndexGroupBuyActivityServiceTest {

    @Resource
    private IIndexGroupBuyMarketService indexGroupBuyMarketService;

    @Test
    public void indexMarketTrailTest() throws Exception {
        MarketProductEntity marketProductEntity = new MarketProductEntity();
        marketProductEntity.setUserId("xiaofuge");
        marketProductEntity.setSource("s01");
        marketProductEntity.setChannel("c01");
        marketProductEntity.setGoodsId("9890001");

        TrailBalanceEntity trialBalanceEntity = indexGroupBuyMarketService.indexMarketTrail(marketProductEntity);
        log.info("请求参数:{}", JSON.toJSONString(marketProductEntity));
        log.info("返回结果:{}", JSON.toJSONString(trialBalanceEntity));

    }

    @Test
    public void test_indexMarketTrial_error() throws Exception {
        MarketProductEntity marketProductEntity = new MarketProductEntity();
        marketProductEntity.setUserId("xiaofuge");
        marketProductEntity.setSource("s01");
        marketProductEntity.setChannel("c01");
        marketProductEntity.setGoodsId("9890004");

        TrailBalanceEntity trialBalanceEntity = indexGroupBuyMarketService.indexMarketTrail(marketProductEntity);
        log.info("请求参数:{}", com.alibaba.fastjson.JSON.toJSONString(marketProductEntity));
        log.info("返回结果:{}", com.alibaba.fastjson.JSON.toJSONString(trialBalanceEntity));
    }
}
