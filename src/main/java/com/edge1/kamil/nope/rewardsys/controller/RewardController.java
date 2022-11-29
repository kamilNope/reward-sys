package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import com.edge1.kamil.nope.rewardsys.service.CustomerPointsRecord;
import com.edge1.kamil.nope.rewardsys.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("")
@RequestMapping("api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    RewardController(RewardService rewardService,
                     CustomerRepository customerRepository,
                     TransactionRepository transactionRepository){
        this.rewardService = rewardService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping ("/{customerId}")
    ResponseEntity<CustomerPointsRecord> getCustomerMonthScore(@PathVariable Long customerId){
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){
            rewardService.sumRewardPoints(0.0);
            return new ResponseEntity<CustomerPointsRecord>(new CustomerPointsRecord(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping ("/{userId}")
    CustomerPointsRecord getUserTotalScore(@PathVariable String userId){
        rewardService.sumRewardPoints(0.0);
        return new CustomerPointsRecord();
    }

}
