package com.sj.phone_store.repository;

import com.sj.phone_store.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneCategoryRepositoryTest {
    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;

    @Test
    void findAllCategory()
    {
        List<PhoneCategory> list=phoneCategoryRepository.findAll();
        for (PhoneCategory phoneCategory : list) {
            System.out.println(phoneCategory);
        }
    }

    @Test
    void findByCategoryType()
    {
        System.out.println(phoneCategoryRepository.findByCategoryType(1));
    }
}