package com.mvphub.types.design.framework;

/**
 * @author mvp
 * @desciption 策略映射器
 *
 * @param <T> 请求参数
 * @param <R> 返回参数
 * @param <D> 动态上下文
 */
public interface StrategyMapper<T, D, R> {
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;
}
