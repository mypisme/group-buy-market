package com.mvphub.domain.activity.service.trail;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.types.design.framework.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mvp
 */
@Service
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory activityStrategyFactory;

    @Override
    public TrailBalanceEntity indexMarketTrail(MarketProductEntity marketProductEntity) throws Exception {
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> strategyHandler = activityStrategyFactory.strategyHandler();

        return strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
    }
}
