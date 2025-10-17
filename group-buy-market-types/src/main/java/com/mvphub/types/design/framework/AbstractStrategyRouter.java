package com.mvphub.types.design.framework;

/**
 * @author Administrator
 * @description 策略路由
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R> {

    protected StrategyHandler<T, D, R> defaultStrategyhandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if (strategyHandler != null) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        } else {
            return defaultStrategyhandler.apply(requestParameter, dynamicContext);
        }
    }
}
