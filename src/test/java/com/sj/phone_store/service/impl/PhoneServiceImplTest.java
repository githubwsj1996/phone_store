package com.sj.phone_store.service.impl;

import com.sj.phone_store.service.PhoneService;
import com.sj.phone_store.vo.DataVO;
import com.sj.phone_store.vo.PhoneInfoVO;
import com.sj.phone_store.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceImplTest {
    @Autowired
    private PhoneService phoneService;

    @Test
    void findAllPhones() {
        DataVO  dataVO=phoneService.findDataVO();
        int id=0;
    }

    @Test
    void findPhoneInfoByCategoryType()
    {
        List<PhoneInfoVO> phoneInfoVOList=phoneService.findPhoneInfoByCategoryType(2);
        int id=0;
    }

    @Test
    void findSpecsByPhoneId()
    {
        SpecsPackageVO specsPackageVO=phoneService.findSpecsByPhoneId(1);
        int id=0;
    }

    @Test
    void subStock(){
        phoneService.subStock(1,1);
    }
}