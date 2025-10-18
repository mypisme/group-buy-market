package com.mvphub.domain.activity.service.trail.node;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.domain.activity.service.trail.abstractGroupBuyMarketSupport;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.types.design.framework.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mvp
 */

@Service
@Slf4j
public class EndNode extends
        abstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> {

    @Override
    public TrailBalanceEntity doApply(MarketProductEntity requestParameter,
                                      DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        SkuVO skuVO = dynamicContext.getSkuVO();
        BigDecimal deductionPrice = dynamicContext.getDeductionPrice();
        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();

        return TrailBalanceEntity.builder()
                .goodsId(skuVO.getGoodsId())
                .deductionPrice(deductionPrice)
                .goodsName(skuVO.getGoodsName())
                .originalPrice(skuVO.getOriginalPrice())
                .endTime(groupBuyActivityDiscountVO.getEndTime())
                .startTime(groupBuyActivityDiscountVO.getStartTime())
                .targetCount(groupBuyActivityDiscountVO.getTarget())
                .isVisible(false)
                .isEnabled(false)
                .build();
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> get(
            MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return defaultStrategyhandler;
    }
}
