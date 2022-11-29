package com.edge1.kamil.nope.rewardsys.service;

import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardServiceTest {

    RewardService rewardService = new RewardService();

    @Test
    void shouldNotSumRewardPointsIfPriceIsLower() {
        // given
        Double price = 40.99;
        List<Transaction> transactions = List.of(new Transaction(1L, price, Date.valueOf(LocalDate.now()),
                new Customer(1L, "TED")));
        // when & then
        assertEquals(0, rewardService.sumRewardPoints(transactions));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigher() {
        // given
        Double price = 99.99;
        List<Transaction> transactions = List.of(new Transaction(1L, price, Date.valueOf(LocalDate.now()),
                new Customer(1L, "TED")));
        // when & then
        assertEquals(49, rewardService.sumRewardPoints(transactions));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigherPlusExtraPoints() {
        // given
        Double price = 120.01;
        List<Transaction> transactions = List.of(new Transaction(1L, price, Date.valueOf(LocalDate.now()),
                new Customer(1L, "TED")));
        // when & then
        assertEquals(90, rewardService.sumRewardPoints(transactions));
    }
}