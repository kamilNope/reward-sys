package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardServiceTest {

    RewardService rewardService = new RewardService();

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(rewardService, "doublePointsThreshold", 100);
        ReflectionTestUtils.setField(rewardService, "singlePointsThreshold", 50);
    }
    @Test
    void shouldNotSumRewardPointsIfPriceIsLower() {

        assertEquals(0, rewardService.countRewardPointsFor(40.99));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigher() {

        assertEquals(49, rewardService.countRewardPointsFor(99.99));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigherPlusExtraPoints() {

        assertEquals(90, rewardService.countRewardPointsFor(120.01));
    }
}