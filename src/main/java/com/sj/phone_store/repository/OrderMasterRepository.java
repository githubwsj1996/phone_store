package com.sj.phone_store.repository;

import com.sj.phone_store.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
