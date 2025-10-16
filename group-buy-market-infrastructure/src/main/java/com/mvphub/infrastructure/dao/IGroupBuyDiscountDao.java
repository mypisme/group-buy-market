package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mvp
 * @description 拼团折扣Dao
 * @Creat 2025-10-16
 */
@Mapper
public interface IGroupBuyDiscountDao {
    List<GroupBuyDiscount> queryGroupBuyDiscountList();
}
