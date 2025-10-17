package com.mvphub.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author mvp
 * @desciption 试算结果
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrailBalanceEntity {
    private String goodsId;
    private String goodsName;
    private BigDecimal originalPrice;
    private BigDecimal deductionPrice;
    private Integer targetCount;
    private Date startTime;
    private Date endTime;
    private Boolean isVisible;
    private Boolean isEnabled;

}
