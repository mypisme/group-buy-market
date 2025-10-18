package com.mvphub.domain.activity.service.discount.impl;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mvp
 * @description 优惠价格——直减
 */

@Service("ZJ")
@Slf4j
public class ZJCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice,
                                     GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        String marketExpr = groupBuyDiscount.getMarketExpr();

        BigDecimal deductionPrice = originalPrice.subtract(new BigDecimal(marketExpr));
        return checkPriceResult(deductionPrice);
    }
}
