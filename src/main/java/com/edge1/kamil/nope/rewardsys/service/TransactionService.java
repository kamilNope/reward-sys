package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    public List<Transaction> selectTransactionsFromPreviousMonth(List<Transaction> transactions){
        LocalDate previousMontDate = LocalDate.now().minusMonths(1L);
        return transactions.stream()
                .filter(transaction -> previousMontDate.isBefore(transaction.getDate().toLocalDate()))
                .collect(Collectors.toList());
    }

}