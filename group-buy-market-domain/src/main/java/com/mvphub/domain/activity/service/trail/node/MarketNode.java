package com.mvphub.domain.activity.service.trail.node;

import com.mvphub.domain.activity.model.entity.MarketProductEntity;
import com.mvphub.domain.activity.model.entity.TrailBalanceEntity;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.domain.activity.service.trail.abstractGroupBuyMarketSupport;
import com.mvphub.domain.activity.service.trail.factory.DefaultActivityStrategyFactory;
import com.mvphub.domain.activity.service.trail.thread.QueryGroupBuyActivityDiscountVOThreadTask;
import com.mvphub.domain.activity.service.trail.thread.QuerySkuVOThreadTask;
import com.mvphub.types.design.framework.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author mvp
 */

@Service
@Slf4j
public class MarketNode extends
        abstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Resource
    private EndNode endNode;

    @Override
    public TrailBalanceEntity doApply(MarketProductEntity requestParameter,
                                      DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> get(
            MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext)
            throws Exception {
        return endNode;
    }

    @Override
    protected void multiThread(MarketProductEntity requestParameter,
                               DefaultActivityStrategyFactory.DynamicContext dynamicContext)
            throws ExecutionException, InterruptedException, TimeoutException {
        QueryGroupBuyActivityDiscountVOThreadTask activityTask = new QueryGroupBuyActivityDiscountVOThreadTask(
                requestParameter.getSource(), requestParameter.getChannel(), activityRepository);
        FutureTask<GroupBuyActivityDiscountVO> futureActivityTask = new FutureTask<>(activityTask);
        threadPoolExecutor.execute(futureActivityTask);

        QuerySkuVOThreadTask skuTask = new QuerySkuVOThreadTask(requestParameter.getGoodsId(), activityRepository);
        FutureTask<SkuVO> futureSkuTask = new FutureTask<>(skuTask);
        threadPoolExecutor.execute(futureSkuTask);

        dynamicContext.setGroupBuyActivityDiscountVO(futureActivityTask.get(timeOut, TimeUnit.MINUTES));
        dynamicContext.setSkuVO(futureSkuTask.get(timeOut, TimeUnit.MINUTES));

    }
}
