package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.errors.CustomerNotFound;
import com.edge1.kamil.nope.rewardsys.errors.TransactionNotFound;
import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import com.edge1.kamil.nope.rewardsys.service.RewardService;
import com.edge1.kamil.nope.rewardsys.service.TransactionService;
import com.edge1.kamil.nope.rewardsys.view.CustomerPointsDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    @GetMapping("/{customerId}/month-score")
    ResponseEntity<CustomerPointsDTO> getCustomerMonthScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new TransactionNotFound(customerId.toString()));

        List<Transaction> transactionsFromMonth = transactionService
                .selectTransactionsFromPrevMonth(transactionsOfCustomer);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFound(customerId.toString()));

        final int monthUserScore = rewardService.sumRewardPoints(transactionsFromMonth);
        return new ResponseEntity<>(new CustomerPointsDTO(customer.getName(), monthUserScore), HttpStatus.OK);
    }

    @GetMapping("/{customerId}/total-score")
    ResponseEntity<CustomerPointsDTO> getCustomerTotalScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new TransactionNotFound(customerId.toString()));

        final int totalPoints = rewardService.sumRewardPoints(transactionsOfCustomer);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFound(customerId.toString()));
        return new ResponseEntity<>(new CustomerPointsDTO(customer.getName(), totalPoints), HttpStatus.OK);
    }

}

