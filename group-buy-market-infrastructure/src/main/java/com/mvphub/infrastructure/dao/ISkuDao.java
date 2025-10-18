package com.mvphub.infrastructure.dao;

import com.mvphub.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mvp
 * @description 商品Dao
 * @Creat 2025-10-16
 */

@Mapper
public interface ISkuDao {
    Sku querySkuByGoodsId(String goodsId);
}
