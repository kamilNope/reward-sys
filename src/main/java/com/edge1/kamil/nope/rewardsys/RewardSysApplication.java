package com.edge1.kamil.nope.rewardsys;

import com.edge1.kamil.nope.rewardsys.entity.Customer;
import com.edge1.kamil.nope.rewardsys.entity.Transaction;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RewardSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardSysApplication.class, args);
    }

    @Bean
    public CommandLineRunner fillCustomers(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        return (args) -> {
            final Customer ted = new Customer(1L, "TED");
            final Customer ann = new Customer(2L, "ANN");
            final Customer bob = new Customer(3L, "BOB");
            customerRepository.save(ted);
            customerRepository.save(ann);
            customerRepository.save(bob);

            customerRepository.save(new Customer(1L, "TED"));
            customerRepository.save(new Customer(2L, "ANN"));
            customerRepository.save(new Customer(1L, "BOB"));

            transactionRepository.save(new Transaction(100L, 49.8, ted));
            transactionRepository.save(new Transaction(101L, 49.8, ted));
            transactionRepository.save(new Transaction(101L, 49.8, ted));
            transactionRepository.save(new Transaction(101L, 49.8, ann));
            transactionRepository.save(new Transaction(101L, 90.0, bob));
        };
    }
}