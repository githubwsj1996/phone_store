package com.sj.phone_store.service.impl;

import com.sj.phone_store.dto.OrderDTO;
import com.sj.phone_store.service.OrderService;
import com.sj.phone_store.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("小明");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(2);
        OrderDTO result=orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void orderDetail() {
        OrderDetailVO orderVO=orderService.orderDetail("1591330309764949252");
        int id=0;
    }

    @Test
    void updatePayStatus(){
        String OrderId=orderService.updatePayStatus("1591330309764949252");
        int i=0;
    }
}