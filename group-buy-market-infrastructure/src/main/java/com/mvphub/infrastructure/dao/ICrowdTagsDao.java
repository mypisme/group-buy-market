package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mvp
 * @description 人群标签
 * @create 2025年10月19日
 */

@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);

}
