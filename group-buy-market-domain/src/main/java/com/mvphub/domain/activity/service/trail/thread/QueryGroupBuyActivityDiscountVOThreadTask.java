package com.mvphub.domain.activity.service.trail.thread;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.util.concurrent.Callable;

/**
 * @author mvp
 * @description 查询拼团活动折扣多线程任务
 * @Creat 2025-10-16
 */

public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String source;

    private final String channel;

    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel,
                                                     IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return activityRepository.queryGroupBuyActivityDiscountVO(source, channel);
    }
}
