package com.mvphub.domain.activity.service.trail.thread;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.ScSkuActivityVO;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author mvp
 * @description 查询拼团活动折扣多线程任务
 * @Creat 2025-10-16
 */

public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String source;

    private final String channel;

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, String goodsId,
                                                     IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        // 查询商品对应活动
        ScSkuActivityVO scSkuActivityVO = activityRepository.queryScSkuByGoodsId(source, channel, goodsId);
        if (null == scSkuActivityVO) return null;
        // 根据活动计算优惠
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }
}
