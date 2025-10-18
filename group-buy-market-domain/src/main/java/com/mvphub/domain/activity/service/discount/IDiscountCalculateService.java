package com.mvphub.domain.activity.service.discount;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @author mvp
 */


public interface IDiscountCalculateService {

    BigDecimal calculate(String userId, BigDecimal originalPrice,
                         GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
