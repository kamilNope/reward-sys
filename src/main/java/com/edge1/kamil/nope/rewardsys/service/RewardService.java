package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RewardService {

    @Value("${double.points.threshold}")
    private int doublePointsThreshold;
    @Value("${single.points.threshold}")
    private int singlePointsThreshold;

    public int sumRewardPoints(List<Transaction> transactions) {
        return countPointsFromSpentMoney(getSumOfTransactions(transactions));
    }

    private Double getSumOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getPrice)
                .reduce(0d, Double::sum);
    }

    private int countPointsFromSpentMoney(Double transactionsSum) {
        if (transactionsSum > doublePointsThreshold) {
            return (int) (((transactionsSum - doublePointsThreshold) * 2) + singlePointsThreshold);
        } else if (transactionsSum > singlePointsThreshold) {
            return (int) (transactionsSum - singlePointsThreshold);
        }
        return 0;
    }

}

