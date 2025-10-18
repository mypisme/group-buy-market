package com.mvphub.infrastructure.adapter.repository;

import com.mvphub.domain.activity.adapter.repository.IActivityRepository;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.infrastructure.dao.IGroupBuyActivityDao;
import com.mvphub.infrastructure.dao.IGroupBuyDiscountDao;
import com.mvphub.infrastructure.dao.ISkuDao;
import com.mvphub.infrastructure.dao.po.GroupBuyActivity;
import com.mvphub.infrastructure.dao.po.GroupBuyDiscount;
import com.mvphub.infrastructure.dao.po.Sku;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Resource
    private ISkuDao skuDao;

    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel) {
        // 根据SC渠道查询配置中最新的一个有效活动
        GroupBuyActivity groupBuyActivity = new GroupBuyActivity();
        groupBuyActivity.setSource(source);
        groupBuyActivity.setChannel(channel);
        GroupBuyActivity activity = groupBuyActivityDao.queryValidGroupBuyActivity(groupBuyActivity);

        // 根据优惠ID查询优惠配置
        GroupBuyDiscount groupBuyDiscount = groupBuyDiscountDao.queryGroupBuyActivityDiscountByDiscountId(
                activity.getDiscountId());

        // 封装ADVO
        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscountVO =
                GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                        .discountName(groupBuyDiscount.getDiscountName())
                        .discountType(groupBuyDiscount.getDiscountType())
                        .discountDesc(groupBuyDiscount.getDiscountDesc())
                        .tagId(groupBuyDiscount.getTagId())
                        .marketExpr(groupBuyDiscount.getMarketExpr())
                        .marketPlan(groupBuyDiscount.getMarketPlan())
                        .build();

        // 组装活动信息返回
        return GroupBuyActivityDiscountVO.builder()
                .activityId(activity.getActivityId())
                .activityName(activity.getActivityName())
                .goodsId(activity.getGoodsId())
                .source(activity.getSource())
                .channel(activity.getChannel())
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
        // 组装商品信息返回
        return SkuVO.builder()
                .goodsName(sku.getGoodsName())
                .goodsId(sku.getGoodsId())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }
}
