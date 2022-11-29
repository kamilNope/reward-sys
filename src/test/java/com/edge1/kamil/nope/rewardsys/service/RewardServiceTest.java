package com.edge1.kamil.nope.rewardsys.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardServiceTest {

    RewardService rewardService = new RewardService();

    @Test
    void shouldNotSumRewardPointsIfPriceIsLower() {
        // given
        Double price = 40.99;
        // when & then
        assertEquals(0, rewardService.sumRewardPoints(price));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigher() {
        // given
        Double price = 99.99;
        // when & then
        assertEquals(49, rewardService.sumRewardPoints(price));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigherPlusExtraPoints() {
        // given
        Double price = 120.01;
        // when & then
        assertEquals(90, rewardService.sumRewardPoints(price));
    }

//    CustomerPointsRecord customerPointsRecord = new CustomerPointsRecord();
//
//    @BeforeEach
//    public void setup(){
//        customerPointsRecord.setUserID("any");
//        customerPointsRecord.setUserScore(0.0);
//    }

}