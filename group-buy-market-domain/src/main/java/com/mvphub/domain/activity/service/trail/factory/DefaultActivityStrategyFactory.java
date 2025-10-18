package com.mvphub.domain.activity.service.trail.factory;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.domain.activity.service.trail.node.RootNode;
import com.mvphub.types.design.framework.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mvp
 */
@Slf4j
@Service
public class DefaultActivityStrategyFactory {

    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrailBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DynamicContext {
        // 拼团活动营销配置值对象
        private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;
        // 商品信息
        private SkuVO skuVO;

    }
}
