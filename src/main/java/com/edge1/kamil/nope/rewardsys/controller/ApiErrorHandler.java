package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.view.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ApiErrorHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<ApiErrorDTO> handleApiException(
            CustomApiException ex) {
        ApiErrorDTO response =
                new ApiErrorDTO("error-0001",
                        "No element found with ID " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}