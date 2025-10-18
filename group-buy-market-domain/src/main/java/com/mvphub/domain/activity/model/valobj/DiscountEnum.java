package com.mvphub.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author mvp
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DiscountEnum {

    BASE(0, "普通优惠"),
    TAG(1, "人群标签");

    private Integer code;
    private String info;

    public static DiscountEnum getDiscountEnum(Integer code) {
        switch (code) {
            case 0:
                return BASE;
            case 1:
                return TAG;
            default:
                throw new RuntimeException("err code");
        }
    }

}
