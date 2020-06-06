package com.sj.phone_store.service;

import com.sj.phone_store.vo.DataVO;
import com.sj.phone_store.vo.PhoneInfoVO;
import com.sj.phone_store.vo.SpecsPackageVO;

import java.util.List;


public interface PhoneService {
    public DataVO findDataVO();
    public List<PhoneInfoVO> findPhoneInfoByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId);
    public void subStock(Integer specsId,Integer quantity);
}
