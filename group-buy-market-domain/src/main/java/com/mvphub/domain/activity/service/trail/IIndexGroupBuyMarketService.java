package com.mvphub.domain.activity.service.trail;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;

/**
 * @author mvp
 */
public interface IIndexGroupBuyMarketService {
    TrailBalanceEntity indexMarketTrail(MarketProductEntity marketProductEntity) throws Exception;
}
