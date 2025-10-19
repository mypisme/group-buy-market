package com.mvphub.domain.tag.service;

/**
 * @author mvp
 * @description 人群标签任务接口
 * @create 2025年10月19日
 */

public interface ITagService {
    /**
     * 执行人群标签批次任务
     *
     * @param tagId   人群ID
     * @param batchId 批次ID
     */
    void executeTagBatchJob(String tagId, String batchId);
}
