package com.mvphub.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mvp
 * @desciption 营销商品
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketProductEntity {
    private String userId;
    private String goodsId;
    private String source;
    private String channel;
}
