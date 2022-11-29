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

@RestController("")
@RequestMapping("api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;
    private CustomerPointsRecord customerPointsRecord = new CustomerPointsRecord();

    RewardController(RewardService rewardService,
                     CustomerRepository customerRepository,
                     TransactionRepository transactionRepository,
                     TransactionService transactionService){
        this.rewardService = rewardService;
        this.transactionService = transactionService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping ("/{customerId}/monthScore")
    ResponseEntity<CustomerPointsRecord> getCustomerMonthScore(@PathVariable Long customerId){
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        if(!transactionsOfCustomer.isEmpty()){
            List<Transaction> transactionsFromMonth = transactionService.selectTransactionsFromPreviousMonth(transactionsOfCustomer);
            customerPointsRecord.setMonthUserScore(rewardService.sumRewardPoints(transactionsFromMonth));
            return new ResponseEntity<>(customerPointsRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/{customerId}/totalScore")
    CustomerPointsRecord getCustomerTotalScore(@PathVariable Long customerId){
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        rewardService.sumRewardPoints(transactionsOfCustomer);
        return new CustomerPointsRecord();
    }

}

