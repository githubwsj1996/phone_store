package com.sj.phone_store.controller;

import com.sj.phone_store.exception.PhoneException;
import com.sj.phone_store.form.AddressForm;
import com.sj.phone_store.service.AddressService;
import com.sj.phone_store.util.ResultUtil;
import com.sj.phone_store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    private ResultVO findAllBuyerAddress()
    {
        return ResultUtil.success(addressService.findAll());
    }

    @PostMapping("create")
    private ResultVO create(@Valid @RequestBody  AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[添加地址]存在错误,address={}",addressForm);
            throw  new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return  ResultUtil.success(null);
    }

    @PutMapping("/update")
    private ResultVO update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           log.error("[修改地址]存在错误,addressForm={}",addressForm);
           throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ResultUtil.success(null);
    }
}
