package com.mvphub.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author mvp
 * @description 拼团活动Dao
 * @Creat 2025-10-16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuVO {

    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private BigDecimal originalPrice;

}
