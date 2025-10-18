package com.mvphub.domain.activity.service.trail.thread;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @author mvp
 * @description 查询拼团活动折扣多线程任务
 * @Creat 2025-10-16
 */

public class QuerySkuVOThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }


    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }
}
