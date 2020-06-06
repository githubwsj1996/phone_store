package com.sj.phone_store.controller;

import com.sj.phone_store.service.PhoneService;
import com.sj.phone_store.util.ResultUtil;
import com.sj.phone_store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneHandler {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index(){
        return ResultUtil.success(phoneService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return  ResultUtil.success(phoneService.findPhoneInfoByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO findSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId){
        return  ResultUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }
}
