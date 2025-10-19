package com.mvphub.infrastructure.adapter.repository;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.model.valobj.DiscountEnum;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.ScSkuActivityVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.infrastructure.dao.IGroupBuyActivityDao;
import com.mvphub.infrastructure.dao.IGroupBuyDiscountDao;
import com.mvphub.infrastructure.dao.IScSkuActivityDao;
import com.mvphub.infrastructure.dao.ISkuDao;
import com.mvphub.infrastructure.dao.po.GroupBuyActivity;
import com.mvphub.infrastructure.dao.po.GroupBuyDiscount;
import com.mvphub.infrastructure.dao.po.ScSkuActivity;
import com.mvphub.infrastructure.dao.po.Sku;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Resource
    private IScSkuActivityDao scSkuActivityDao;

    @Resource
    private ISkuDao skuDao;

    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId) {
        // 根据SC渠道查询配置中最新的一个有效活动
        GroupBuyActivity activity = groupBuyActivityDao.queryValidGroupBuyActivityByActivityId(activityId);

        if (activity == null) {
            return null;
        }

        // 根据优惠ID查询优惠配置
        GroupBuyDiscount groupBuyDiscount = groupBuyDiscountDao.queryGroupBuyActivityDiscountByDiscountId(
                activity.getDiscountId());

        // 封装ADVO
        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscountVO =
                GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                        .discountName(groupBuyDiscount.getDiscountName())
                        .discountType(DiscountEnum.getDiscountEnum(groupBuyDiscount.getDiscountType()))
                        .discountDesc(groupBuyDiscount.getDiscountDesc())
                        .tagId(groupBuyDiscount.getTagId())
                        .marketExpr(groupBuyDiscount.getMarketExpr())
                        .marketPlan(groupBuyDiscount.getMarketPlan())
                        .build();

        // 组装活动信息返回
        return GroupBuyActivityDiscountVO.builder()
                .activityId(activity.getActivityId())
                .activityName(activity.getActivityName())
                .groupType(activity.getGroupType())
                .status(activity.getStatus())
                .tagScope(activity.getTagScope())
                .tagId(activity.getTagId())
                .target(activity.getTarget())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .validTime(activity.getValidTime())
                .takeLimitCount(activity.getTakeLimitCount())
                .groupBuyDiscount(groupBuyDiscountVO)
                .build();
    }

    @Override
    public SkuVO querySkuByGoodsId(String goodsId) {
        Sku sku = skuDao.querySkuByGoodsId(goodsId);
        if (null == sku) {
            return null;
        }
        // 组装商品信息返回
        return SkuVO.builder()
                .goodsName(sku.getGoodsName())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }

    @Override
    public ScSkuActivityVO queryScSkuByGoodsId(String source, String channel, String goodsId) {
        ScSkuActivity scSkuActivities = scSkuActivityDao.querySkuByGoodsId(goodsId);

        if (null == scSkuActivities) return null;

        return ScSkuActivityVO.builder()
                .source(scSkuActivities.getSource())
                .channel(scSkuActivities.getChannel())
                .goodsId(scSkuActivities.getGoodsId())
                .activityId(scSkuActivities.getActivityId())
                .build();
    }
}
