package com.sj.phone_store.enums;

import lombok.Getter;

@Getter
public enum OrderEnum {
    ZHIFU_FAILED(0,"未支付"),
    ZHIFU_SUCCESS(1,"已支付"),
    ORDER_DETAIL_EXIST(3,"订单信息不存在");

    private Integer code;
    private String msg;

    OrderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
