package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.errors.CustomerNotFound;
import com.edge1.kamil.nope.rewardsys.errors.RewardException;
import com.edge1.kamil.nope.rewardsys.errors.TransactionNotFound;
import com.edge1.kamil.nope.rewardsys.view.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ApiErrorHandler {

    @ExceptionHandler(TransactionNotFound.class)
    public ResponseEntity<ApiErrorDTO> handleTransactionNotFoundException(RewardException ex) {
        ApiErrorDTO response =
                new ApiErrorDTO("error-0001",
                        "No transaction found with ID " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ApiErrorDTO> handleCustomerNotFoundException(RewardException ex) {
        ApiErrorDTO response =
                new ApiErrorDTO("error-0001",
                        "No transaction found with ID " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}