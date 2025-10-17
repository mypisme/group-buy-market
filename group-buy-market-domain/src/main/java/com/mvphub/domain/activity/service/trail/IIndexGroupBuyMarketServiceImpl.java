package com.mvphub.domain.activity.service.trail;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.types.design.framework.StrategyHandler;
import org.springframework.stereotype.Service;

/**
 * @author mvp
 */
@Service
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    private DefaultActivityStrategyFactory activityStrategyFactory;

    @Override
    public TrailBalanceEntity indexMarketTrail(MarketProductEntity marketProductEntity) throws Exception {
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> strategyHandler = activityStrategyFactory.strategyHandler();

        TrailBalanceEntity trailBalanceEntity = strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
        return trailBalanceEntity;
    }
}
