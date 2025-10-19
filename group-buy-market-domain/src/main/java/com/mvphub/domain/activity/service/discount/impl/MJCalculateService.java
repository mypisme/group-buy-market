package com.mvphub.domain.activity.service.discount.impl;

import com.mvphub.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.mvphub.domain.activity.service.discount.AbstractDiscountCalculateService;
import com.mvphub.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mvp
 * @description 优惠价格——满减
 */

@Service("MJ")
@Slf4j
public class MJCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice,
                                     GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        String marketExpr = groupBuyDiscount.getMarketExpr();
        String[] split = marketExpr.split(Constants.SPLIT);
        BigDecimal x = new BigDecimal(split[0]);
        BigDecimal y = new BigDecimal(split[1]);

        // 是否达到满减条件
        if (originalPrice.compareTo(x) < 0) {
            return originalPrice;
        }
        // 计算满减后金额
        BigDecimal deductionPrice = originalPrice.subtract(y);
        return checkPriceResult(deductionPrice);
    }
}
