package com.mvphub.types.design.framework;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * @description 策略路由
 */
@Setter
@Getter
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R> {

    protected StrategyHandler<T, D, R> defaultStrategyhandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if (strategyHandler != null) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        } else {
            return defaultStrategyhandler.apply(requestParameter, dynamicContext);
        }
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        multiThread(requestParameter, dynamicContext);
        return doApply(requestParameter, dynamicContext);
    }

    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;

    protected abstract void multiThread(T requestParameter, D dynamicContext)
            throws ExecutionException, InterruptedException, TimeoutException;
}
