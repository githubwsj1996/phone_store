package com.sj.phone_store.exception;

import com.sj.phone_store.enums.OrderEnum;

public class OrderException extends RuntimeException{
    public OrderException(OrderEnum orderEnum) {
        super(orderEnum.getMsg());
    }
}
