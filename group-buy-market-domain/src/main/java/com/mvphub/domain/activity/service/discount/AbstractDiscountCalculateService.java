package com.mvphub.domain.activity.service.discount;

import com.mvphub.domain.activity.model.valobj.DiscountEnum;
import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @author mvp
 */


public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService {


    public static final String MIN_PRICE = "0.01";

    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice,
                                GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if (DiscountEnum.TAG.equals(groupBuyDiscount.getDiscountType())) {
            boolean isCrowdRange = filterUserId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange)
                return originalPrice;
        }
        return doCalculate(originalPrice, groupBuyDiscount);
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice,
                                            GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

    private boolean filterUserId(String userId, String tagId) {
        return true;
    }

    protected BigDecimal checkPriceResult(BigDecimal deductionPrice) {
        if (deductionPrice.compareTo(BigDecimal.ZERO) < 0) {
            // 最低支付价格
            return new BigDecimal(MIN_PRICE);
        }
        return deductionPrice;
    }
}
