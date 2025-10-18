package com.mvphub.domain.activity.service.discount.impl;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mvp
 * @description 优惠价格——折扣
 */

@Service("ZK")
@Slf4j
public class ZKCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice,
                                     GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        String marketExpr = groupBuyDiscount.getMarketExpr();

        BigDecimal deductionPrice = originalPrice.multiply(new BigDecimal(marketExpr));
        return checkPriceResult(deductionPrice);
    }
}
