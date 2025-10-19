package com.mvphub.domain.activity.adapter.repository;

import com.mvphub.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author mvp
 * @description 人群标签任务仓储
 * @create 2025年10月19日
 */

public interface ITagRepository {

    /**
     * 查询任务标签任务
     * @param tagId 人群标签ID
     * @param batchId 任务批次ID
     * @return CrowdTagsJobEntity
     */
    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    /**
     * 添加用户标签
     *
     * @param tagId 人群标签ID
     * @param userId 用户ID
     */
    void addCrowdTagsUserId(String tagId, String userId);

    /**
     * 更新人群标签统计量
     *
     * @param tagId 人群标签ID
     * @param size 标签人群数量
     */
    void updateCrowdTagsStatistics(String tagId, int size);
}
