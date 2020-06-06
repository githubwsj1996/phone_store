package com.sj.phone_store.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PHONE_STOCK_ERROR(0,"手机库存不足"),
    PHONE_SPECS_EXIST(1,"手机规格不存在"),
    PHONE_INFO_EXIST(2,"手机规格不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
