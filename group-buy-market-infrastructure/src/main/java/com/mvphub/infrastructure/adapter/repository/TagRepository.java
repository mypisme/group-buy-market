package com.mvphub.infrastructure.adapter.repository;

import com.mvphub.domain.activity.adapter.repository.ITagRepository;
import com.mvphub.domain.tag.model.entity.CrowdTagsJobEntity;
import com.mvphub.infrastructure.dao.ICrowdTagsDao;
import com.mvphub.infrastructure.dao.ICrowdTagsDetailDao;
import com.mvphub.infrastructure.dao.ICrowdTagsJobDao;
import com.mvphub.infrastructure.dao.po.CrowdTags;
import com.mvphub.infrastructure.dao.po.CrowdTagsDetail;
import com.mvphub.infrastructure.dao.po.CrowdTagsJob;
import com.mvphub.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author mvp
 * @description 人群标签任务仓储实现类
 * @create 2025年10月19日
 */

@Repository
public class TagRepository implements ITagRepository {

    @Resource
    private ICrowdTagsDao crowdTagsDao;

    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {
        CrowdTagsJob crowdTagsJob = new CrowdTagsJob();
        crowdTagsJob.setTagId(tagId);
        crowdTagsJob.setBatchId(batchId);
        CrowdTagsJob queriedCrowdTagsJob = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJob);

        return CrowdTagsJobEntity.builder()
                .tagRule(queriedCrowdTagsJob.getTagRule())
                .tagType(queriedCrowdTagsJob.getTagType())
                .statEndTime(queriedCrowdTagsJob.getStatEndTime())
                .statStartTime(queriedCrowdTagsJob.getStatStartTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetail = new CrowdTagsDetail();
        crowdTagsDetail.setTagId(tagId);
        crowdTagsDetail.setUserId(userId);
        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetail);

            // 获取BitSet
            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId), true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int size) {
        CrowdTags crowdTags = new CrowdTags();
        crowdTags.setTagId(tagId);
        crowdTags.setStatistics(size);
        crowdTagsDao.updateCrowdTagsStatistics(crowdTags);
    }
}
