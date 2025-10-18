package com.mvphub.domain.activity.service.trail;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.types.design.framework.AbstractMultiThreadStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author mvp
 */
public abstract class abstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrailBalanceEntity> extends
        AbstractMultiThreadStrategyRouter<com.mvphub.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.mvphub.domain.activity.model.entity.TrailBalanceEntity> {

    protected long timeOut = 500;

    @Resource
    protected IActivityRepository activityRepository;

    @Override
    protected void multiThread(com.mvphub.domain.activity.model.entity.MarketProductEntity requestParameter,
                               DefaultActivityStrategyFactory.DynamicContext dynamicContext)
            throws ExecutionException, InterruptedException, TimeoutException {
        // 缺省方法
    }
}
