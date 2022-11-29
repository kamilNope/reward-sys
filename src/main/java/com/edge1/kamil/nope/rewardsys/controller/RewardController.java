package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import com.edge1.kamil.nope.rewardsys.service.CustomerPointsRecord;
import com.edge1.kamil.nope.rewardsys.service.RewardService;
import com.edge1.kamil.nope.rewardsys.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    RewardController(RewardService rewardService,
                     CustomerRepository customerRepository,
                     TransactionRepository transactionRepository,
                     TransactionService transactionService) {
        this.rewardService = rewardService;
        this.transactionService = transactionService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{customerId}/month-score")
    ResponseEntity<CustomerPointsRecord> getCustomerMonthScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        if (!transactionsOfCustomer.isEmpty()) {
            List<Transaction> transactionsFromMonth = transactionService.selectTransactionsFromPrevMonth(
                    transactionsOfCustomer);

            String customer = customerRepository.findById(customerId).get().getName();
            final int monthUserScore = rewardService.sumRewardPoints(transactionsFromMonth);
            return new ResponseEntity<>(new CustomerPointsRecord(customer, monthUserScore), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{customerId}/total-score")
    ResponseEntity<CustomerPointsRecord> getCustomerTotalScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        if (!transactionsOfCustomer.isEmpty()) {
            final int totalPoints = rewardService.sumRewardPoints(transactionsOfCustomer);
            String customer = customerRepository.findById(customerId).get().getName();
            return new ResponseEntity<>(new CustomerPointsRecord(customer, totalPoints), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

