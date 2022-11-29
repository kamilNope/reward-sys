package com.edge1.kamil.nope.rewardsys.repository;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(Long customerId);
}