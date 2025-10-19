package com.mvphub.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mvp
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScSkuActivityVO {
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 来源
     */
    private String source;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 商品ID
     */
    private String goodsId;
}
