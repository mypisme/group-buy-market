package com.mvphub.types.design.framework;

/**
 * @description 策略处理器
 * @author Administrator
 */
public interface StrategyHandler<T, D, R> {
    StrategyHandler DEFAULT = (T, D) -> null ;

    R apply(T requestParameter, D dynamicContext) throws Exception;
}
