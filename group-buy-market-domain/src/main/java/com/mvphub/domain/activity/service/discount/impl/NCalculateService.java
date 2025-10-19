package com.mvphub.domain.activity.service.discount.impl;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mvp
 * @description 优惠价格——N元购
 */

@Service("N")
@Slf4j
public class NCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice,
                                     GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {

        BigDecimal deductionPrice = new BigDecimal(groupBuyDiscount.getMarketExpr());
        return checkPriceResult(deductionPrice);
    }
}
