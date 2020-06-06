package com.sj.phone_store.service.impl;

import com.sj.phone_store.entity.PhoneCategory;
import com.sj.phone_store.entity.PhoneInfo;
import com.sj.phone_store.entity.PhoneSpecs;
import com.sj.phone_store.enums.ResultEnum;
import com.sj.phone_store.exception.PhoneException;
import com.sj.phone_store.repository.PhoneCategoryRepository;
import com.sj.phone_store.repository.PhoneInfoRepository;
import com.sj.phone_store.repository.PhoneSpecsRepository;
import com.sj.phone_store.service.PhoneService;
import com.sj.phone_store.util.PhoneUtil;
import com.sj.phone_store.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;

    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();

//        List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
//        for (PhoneCategory phoneCategory : phoneCategoryList) {
//            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
//            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());
//            phoneCategoryVO.setCategoryType(phoneCategory.getCategoryType());
//            phoneCategoryVOList.add(phoneCategoryVO);
//        }

        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVO.setCategories(phoneCategoryVOList);


        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findPhoneInfoByCategoryType(phoneCategoryList.get(0).getCategoryType());

//        List<PhoneInfoVO> phoneInfoVOList=new ArrayList<>();
//        for (PhoneInfo phoneInfo : phoneInfoList) {
//            PhoneInfoVO phoneInfoVO=new PhoneInfoVO();
//            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);
//            phoneInfoVO.setPhoneTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
//            phoneInfoVOList.add(phoneInfoVO);
//        }

        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        dataVO.setPhones(phoneInfoVOList);

        return dataVO;
    }

    @Override
    public List<PhoneInfoVO> findPhoneInfoByCategoryType(Integer categoryType) {
        List<PhoneInfo> phoneInfoList=phoneInfoRepository.findPhoneInfoByCategoryType(categoryType);

        List<PhoneInfoVO> phoneInfoVOList=phoneInfoList.stream()
                .map(e->new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        return phoneInfoVOList;
    }

    @Override
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId) {
        PhoneInfo phoneInfo=phoneInfoRepository.findById(phoneId).get();
        List<PhoneSpecs> phoneSpecsList=phoneSpecsRepository.findSpecsByPhoneId(phoneId);

        List<PhoneSpecsVO> phoneSpecsVOList=new ArrayList<>();;
        List<PhoneSpecsCasVO> phoneSpecsCasVOList=new ArrayList<>();
        PhoneSpecsVO phoneSpecsVO=null;
        PhoneSpecsCasVO phoneSpecsCasVO=null;
        for (PhoneSpecs phoneSpecs : phoneSpecsList) {
            phoneSpecsVO=new PhoneSpecsVO();
            phoneSpecsVO.setSpecsId(phoneSpecs.getSpecsId());
            phoneSpecsVO.setSpecsName(phoneSpecs.getSpecsName());
            phoneSpecsVO.setSpecsIcon(phoneSpecs.getSpecsIcon());
            phoneSpecsVO.setSpecsPreview(phoneSpecs.getSpecsPreview());

            phoneSpecsCasVO=new PhoneSpecsCasVO();
            phoneSpecsCasVO.setSpecsId(phoneSpecs.getSpecsId());
            phoneSpecsCasVO.setSpecsPrice(phoneSpecs.getSpecsPrice());
            phoneSpecsCasVO.setSpecsStock(phoneSpecs.getSpecsStock());

            phoneSpecsVOList.add(phoneSpecsVO);
            phoneSpecsCasVOList.add(phoneSpecsCasVO);
        }
        TreeVO treeVO=new TreeVO();
        treeVO.setV(phoneSpecsVOList);
        List<TreeVO> treeVOList=new ArrayList<>();
        treeVOList.add(treeVO);

        Integer price1=phoneInfo.getPhonePrice().intValue();
        String price=(price1+".00");
        Map<String,String> goods=new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        Integer stock_num=phoneInfo.getPhoneStock();

        SkuVO skuVO=new SkuVO();
        skuVO.setTree(treeVOList);
        skuVO.setList(phoneSpecsCasVOList);
        skuVO.setPrice(price);
        skuVO.setStock_num(stock_num);

        SpecsPackageVO specsPackageVO=new SpecsPackageVO();
        specsPackageVO.setGoods(goods);
        specsPackageVO.setSku(skuVO);
        return specsPackageVO;
    }

    @Override
    public void subStock(Integer specsId,Integer quantity) {
        PhoneSpecs phoneSpecs=phoneSpecsRepository.findById(specsId).get();
        PhoneInfo phoneInfo=phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();

        Integer result=phoneSpecs.getSpecsStock()-quantity;
        if(result<0){
            log.error("[减规格库存]库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        phoneSpecs.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        phoneSpecsRepository.save(phoneSpecs);

        result=phoneInfo.getPhoneStock()-quantity;
        if(result<0){
            log.error("[减手机库存]库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneInfo.setPhoneStock(result);
        phoneInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        phoneInfoRepository.save(phoneInfo);
    }
}
