package com.edge1.kamil.nope.rewardsys.service;

import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private static final int DOUBLE_POINTS_THRESHOLD = 100;
    private static final int SINGLE_POINTS_THRESHOLD = 50;
    Double transactionSum;
    CustomerPointsRecord customerPointsRecord = new CustomerPointsRecord();

    public int sumRewardPoints(Double price) {
        if (price > DOUBLE_POINTS_THRESHOLD) {
            return (int) (((price - DOUBLE_POINTS_THRESHOLD) * 2) + SINGLE_POINTS_THRESHOLD);
        } else if (price > SINGLE_POINTS_THRESHOLD) {
            return (int) (price - SINGLE_POINTS_THRESHOLD);
        }
        return 0;
    }

}
