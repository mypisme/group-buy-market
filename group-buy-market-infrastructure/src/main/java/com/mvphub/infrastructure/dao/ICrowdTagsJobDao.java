package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mvp
 * @description 人群标签任务
 * @create 2025年10月19日
 */

@Mapper
public interface ICrowdTagsJobDao {
    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);
}
