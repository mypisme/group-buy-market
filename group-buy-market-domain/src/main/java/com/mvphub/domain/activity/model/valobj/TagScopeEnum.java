package com.mvphub.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author mvp
 * @description 人群可见-可参与枚举
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TagScopeEnum {

    VISIBLE(true, false, "拼团是否可见"),
    ENABLED(true, false, "拼团是否可参与"),
    ;

    private boolean allow;
    private boolean refuse;
    private String desc;
}
