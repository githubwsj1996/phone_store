package com.sj.phone_store.controller;

import com.sj.phone_store.dto.OrderDTO;
import com.sj.phone_store.exception.PhoneException;
import com.sj.phone_store.service.OrderService;
import com.sj.phone_store.util.ResultUtil;
import com.sj.phone_store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO createOrder(@RequestBody @Valid OrderDTO orderDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[创建订单]存在错误，orderDTO={}",orderDTO);
            throw  new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO result=orderService.create(orderDTO);
        Map<String,String> data=new HashMap<>();
        data.put("orderId",result.getOrderId());
        return ResultUtil.success(data);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO orderDetail(@PathVariable("orderId") String orderId){
        return  ResultUtil.success(orderService.orderDetail(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO updatePayStatus(@PathVariable("orderId") String orderId){
        String result=orderService.updatePayStatus(orderId);
        Map<String,String> data=new HashMap<>();
        data.put("orderId",result);
        return  ResultUtil.success(data);
    }
}
