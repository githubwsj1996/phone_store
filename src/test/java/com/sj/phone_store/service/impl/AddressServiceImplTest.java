package com.sj.phone_store.service.impl;

import com.sj.phone_store.form.AddressForm;
import com.sj.phone_store.service.AddressService;
import com.sj.phone_store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> list=addressService.findAll();
        int c=0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm=new AddressForm();
        addressForm.setId(7);
        addressForm.setName("张2");
        addressForm.setTel("13678900987");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号305室");
        addressService.saveOrUpdate(addressForm);
    }
}