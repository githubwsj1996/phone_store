package com.sj.phone_store.repository;

import com.sj.phone_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Test
    void findAll()
    {
        List<BuyerAddress> list=buyerAddressRepository.findAll();
        for (BuyerAddress buyerAddress : list) {
            System.out.println(buyerAddress);
        }
    }

    @Test
    void save()
    {
        BuyerAddress buyerAddress=new BuyerAddress();
        buyerAddress.setBuyerName("小明");
        buyerAddress.setAreaCode(330104);
        buyerAddress.setBuyerAddress("浙江省杭州市江干区光明路189号 10楼  402室");
        buyerAddress.setBuyerPhone("13784146215");
        buyerAddressRepository.save(buyerAddress);
    }

    @Test
    void update()
    {
        BuyerAddress buyerAddress=buyerAddressRepository.findById(5).get();
        buyerAddress.setBuyerName("小王");
        buyerAddressRepository.save(buyerAddress);
    }
}