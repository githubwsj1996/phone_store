package com.sj.phone_store.service.impl;

import com.sj.phone_store.entity.BuyerAddress;
import com.sj.phone_store.form.AddressForm;
import com.sj.phone_store.repository.BuyerAddressRepository;
import com.sj.phone_store.service.AddressService;
import com.sj.phone_store.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

   @Autowired
   private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAll() {
        List<AddressVO> list=buyerAddressRepository.findAll().stream()
                .map(e->new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode().toString(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());
        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress=null;
        if(addressForm.getId()==null){
            buyerAddress=new BuyerAddress();
        }else{
            buyerAddress=buyerAddressRepository.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(Integer.parseInt(addressForm.getAreaCode()));
        Timestamp t=new Timestamp(System.currentTimeMillis());
        buyerAddress.setUpdateTime(t);
        buyerAddress.setCreateTime(t);
        buyerAddressRepository.save(buyerAddress);
    }
}
