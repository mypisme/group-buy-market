package com.mvphub.domain.activity.adapter.repository;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.ScSkuActivityVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;

/**
 * @author mvp
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    ScSkuActivityVO queryScSkuByGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowRange(String tagId, String userId);
}
