package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.CrowdTagsDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mvp
 * @description 人群标签明细
 * @create 2025年10月19日
 */

@Mapper
public interface ICrowdTagsDetailDao {

    void addCrowdTagsUserId(CrowdTagsDetail crowdTagsDetailReq);
}
