package com.sj.phone_store.service;

import com.sj.phone_store.dto.OrderDTO;
import com.sj.phone_store.vo.OrderDetailVO;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO orderDetail(String orderId);
    public String updatePayStatus(String orderId);
}
