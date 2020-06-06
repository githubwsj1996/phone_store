package com.sj.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;
    private String phoneName;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
    @JsonProperty("num")
    private Integer phoneQuantity;
    @JsonProperty("specs")
    private String specsName;
    @JsonProperty("price")
    private String specsPrice;
    @JsonProperty("icon")
    private String phoneIcon;
    @JsonProperty("amount")
    private Integer orderAmount;
    private Integer payStatus;
    private Integer freight=10;
}
