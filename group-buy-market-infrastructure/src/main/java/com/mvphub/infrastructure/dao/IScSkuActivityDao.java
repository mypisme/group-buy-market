package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.ScSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mvp
 * @description 活动-商品信息DAO
 * @create 2025年10月19日
 */

@Mapper
public interface IScSkuActivityDao {
    ScSkuActivity querySkuByGoodsId(String goodsId);
}
