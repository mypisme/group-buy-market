package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mvp
 * @description 拼团活动Dao
 * @Creat 2025-10-16
 */
@Mapper
public interface IGroupBuyActivityDao {
    List<GroupBuyActivity> queryGroupBuyActivityList();

    GroupBuyActivity queryValidGroupBuyActivityByActivityId(Long activityId);
}
