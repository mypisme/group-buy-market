package com.mvphub.domain.activity.adapter.repository;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.model.valobj.SkuVO;
import com.mvphub.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author mvp
 * @description 人群标签任务仓储
 * @create 2025年10月19日
 */

public interface ITagRepository {

    /**
     * 查询任务标签任务
     * @param tagId
     * @param batchId
     * @return
     */
    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    /**
     * 添加用户标签
     *
     * @param tagId
     * @param userId
     */
    void addCrowdTagsUserId(String tagId, String userId);

    /**
     * 更新人群标签统计量
     *
     * @param tagId
     * @param size
     */
    void updateCrowdTagsStatistics(String tagId, int size);
}
