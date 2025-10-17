package com.mvphub.domain.activity.service.trail.node;

import com.mvphub.domain.activity.service.trail.abstractGroupBuyMarketSupport;
import com.mvphub.types.design.framework.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mvp
 */

@Service
@Slf4j
public class EndNode<MarketProductEntity, DynamicContext, TrailBalanceEntity> extends abstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrailBalanceEntity> {

    @Override
    public TrailBalanceEntity apply(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DynamicContext, TrailBalanceEntity> get(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws Exception {
        return null;
    }
}
