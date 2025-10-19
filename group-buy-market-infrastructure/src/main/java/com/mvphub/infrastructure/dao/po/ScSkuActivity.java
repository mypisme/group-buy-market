package com.mvphub.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author mvp
 * @description 活动-商品信息实体类
 * @create 2025年10月19日
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScSkuActivity {
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 渠道
     */
    private String source;
    /**
     * 来源
     */
    private String channel;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 活动ID
     */
    private Long activityId;
}
