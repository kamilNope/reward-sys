package com.edge1.kamil.nope.rewardsys.repository;

import com.edge1.kamil.nope.rewardsys.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}