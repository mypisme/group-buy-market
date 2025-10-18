package com.mvphub.domain.activity.service.trail.node;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.service.trail.abstractGroupBuyMarketSupport;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.types.design.framework.StrategyHandler;
import com.mvphub.types.enums.ResponseCode;
import com.mvphub.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mvp
 */

@Service
@Slf4j
public class RootNode extends abstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> {

    @Resource
    private SwitchNode switchNode;

    @Override
    public TrailBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        if (StringUtils.isBlank(requestParameter.getGoodsId()) ||
                StringUtils.isBlank(requestParameter.getChannel()) ||
                StringUtils.isBlank(requestParameter.getSource()) ||
                StringUtils.isBlank(requestParameter.getUserId())) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return switchNode;
    }
}
