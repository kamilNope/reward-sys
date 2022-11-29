package com.edge1.kamil.nope.rewardsys.repository;

import com.edge1.kamil.nope.rewardsys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(@Param("ID") Integer id);


}