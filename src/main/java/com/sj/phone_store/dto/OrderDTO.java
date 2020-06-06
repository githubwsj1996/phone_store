package com.sj.phone_store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderDTO {
    private String orderId;
    @JsonProperty("name")
    @NotBlank(message = "姓名不能为空")
    private String buyerName;
    @JsonProperty("tel")
    @NotBlank(message = "手机号不能为空")
    private String buyerPhone;
    @JsonProperty("address")
    @NotBlank(message = "地址不能为空")
    private String buyerAddress;
    private Integer specsId;
    @JsonProperty("quantity")
    private Integer phoneQuantity;
}
