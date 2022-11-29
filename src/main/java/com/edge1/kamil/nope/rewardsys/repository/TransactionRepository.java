package com.edge1.kamil.nope.rewardsys.repository;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}