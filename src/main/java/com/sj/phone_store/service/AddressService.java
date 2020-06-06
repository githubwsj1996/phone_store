package com.sj.phone_store.service;



import com.sj.phone_store.form.AddressForm;
import com.sj.phone_store.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}
