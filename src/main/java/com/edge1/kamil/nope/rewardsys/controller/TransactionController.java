package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.errors.TransactionNotFound;
import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import com.edge1.kamil.nope.rewardsys.view.TransactionDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/transactions")
class TransactionController {

    final TransactionRepository transactionRepository;
    final CustomerRepository customerRepository;


    @PostMapping(value = "/add")
    ResponseEntity<TransactionDTO> addNewTransactionOfCustomer(@RequestBody TransactionDTO transactionDTO) {
        Customer customer = customerRepository.findById(transactionDTO.getCustomerId())
                .orElseThrow(() -> new TransactionNotFound(transactionDTO.getCustomerId().toString()));

        Transaction transaction = new Transaction
                (
                        transactionDTO.getId(),
                        transactionDTO.getPrice(),
                        Date.valueOf(LocalDate.now()),
                        customer
                );
        final Transaction addedTransaction = transactionRepository.save(transaction);
        TransactionDTO resultTransaction = new TransactionDTO
                (
                        addedTransaction.getId(),
                        transactionDTO.getPrice(),
                        transactionDTO.getCustomerId()
                );
        return new ResponseEntity<>(resultTransaction, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    ResponseEntity<TransactionDTO> updateTransactionOfCustomer(@RequestBody TransactionDTO transactionDTO) {
        Customer customer = customerRepository.findById(transactionDTO.getCustomerId())
                .orElseThrow(() -> new TransactionNotFound(transactionDTO.getCustomerId().toString()));

        Transaction transaction = new Transaction
                (
                        transactionDTO.getId(),
                        transactionDTO.getPrice(),
                        Date.valueOf(LocalDate.now()),
                        customer
                );
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
    }

}
