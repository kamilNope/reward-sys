package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {
    private static final int DOUBLE_POINTS_THRESHOLD = 100;
    private static final int SINGLE_POINTS_THRESHOLD = 50;

    public int sumRewardPoints(List<Transaction> transactions) {
        return countPointsFromSpentMoney(getSumOfTransactions(transactions));
    }

    private Double getSumOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getPrice)
                .reduce(0d, Double::sum);
    }

    private int countPointsFromSpentMoney(Double transactionsSum) {
        if (transactionsSum > DOUBLE_POINTS_THRESHOLD) {
            return (int) (((transactionsSum - DOUBLE_POINTS_THRESHOLD) * 2) + SINGLE_POINTS_THRESHOLD);
        } else if (transactionsSum > SINGLE_POINTS_THRESHOLD) {
            return (int) (transactionsSum - SINGLE_POINTS_THRESHOLD);
        }
        return 0;
    }

}

