package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class RewardService {

    @Value("${double.points.threshold}")
    private double doublePointsThreshold;
    @Value("${single.points.threshold}")
    private double singlePointsThreshold;

    public int sumRewardPoints(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getRewardPoints)
                .reduce(0, Integer::sum);
    }

    public int countRewardPointsFor(Double transactionsMoney) {
        log.info(transactionsMoney.toString());
        if (transactionsMoney > doublePointsThreshold) {
            return (int) (((transactionsMoney - doublePointsThreshold) * 2) + singlePointsThreshold);
        } else if (transactionsMoney > singlePointsThreshold) {
            return (int) (transactionsMoney - singlePointsThreshold);
        }
        return 0;
    }

}

