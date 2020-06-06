package com.sj.phone_store.service.impl;

import com.sj.phone_store.dto.OrderDTO;
import com.sj.phone_store.entity.OrderMaster;
import com.sj.phone_store.entity.PhoneInfo;
import com.sj.phone_store.entity.PhoneSpecs;
import com.sj.phone_store.enums.OrderEnum;
import com.sj.phone_store.enums.ResultEnum;
import com.sj.phone_store.exception.OrderException;
import com.sj.phone_store.exception.PhoneException;
import com.sj.phone_store.repository.OrderMasterRepository;
import com.sj.phone_store.repository.PhoneInfoRepository;
import com.sj.phone_store.repository.PhoneSpecsRepository;
import com.sj.phone_store.service.OrderService;
import com.sj.phone_store.service.PhoneService;
import com.sj.phone_store.util.KeyUtil;
import com.sj.phone_store.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //用户信息
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        //规格信息
        PhoneSpecs phoneSpecs=phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if(phoneSpecs==null)
        {
            log.error("[创建订单]手机规格不存在,phoneSpecs={}",phoneSpecs);
            throw new PhoneException(ResultEnum.PHONE_SPECS_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs,orderMaster);

        //手机信息
        PhoneInfo phoneInfo=phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if(phoneInfo==null)
        {
            log.error("[手机信息]不存在,phoneInfo={}",phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_INFO_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo,orderMaster);

        //总价
        BigDecimal orderAmount=new BigDecimal(0);
        orderAmount=phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal("10"));
        orderMaster.setOrderAmount(orderAmount);

        //orderId
        orderMaster.setOrderId(KeyUtil.createId());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //支付状态 OrderEnum
        orderMaster.setPayStatus(OrderEnum.ZHIFU_FAILED.getCode());

        orderMaster.setCreateTime(new Timestamp(System.currentTimeMillis()));
        orderMaster.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        //修改库存
        phoneService.subStock(orderDTO.getSpecsId(),orderDTO.getPhoneQuantity());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }

    @Override
    public OrderDetailVO orderDetail(String orderId) {
        OrderDetailVO orderVO=new OrderDetailVO();

        OrderMaster orderMaster=orderMasterRepository.findById(orderId).get();
        if(orderMaster==null){
           log.error("[查询订单]订单不存在,orderMaster={}",orderMaster);
           throw new OrderException(OrderEnum.ORDER_DETAIL_EXIST);
        }
        BeanUtils.copyProperties(orderMaster,orderVO);

        orderVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal("100"))+".00");
        orderVO.setOrderAmount(orderMaster.getOrderAmount().intValue());

        return orderVO;
    }

    @Override
    public String updatePayStatus(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findById(orderId).get();
        if(orderMaster==null)
        {
            log.error("[支付订单]订单不存在,orderMaster={}",orderMaster);
            throw new OrderException(OrderEnum.ORDER_DETAIL_EXIST);
        }

        if(orderMaster.getPayStatus().equals(OrderEnum.ZHIFU_FAILED.getCode())){
            orderMaster.setPayStatus(OrderEnum.ZHIFU_SUCCESS.getCode());
            orderMasterRepository.save(orderMaster);
        }
        return orderId;
    }

}
