package com.edge1.kamil.nope.rewardsys.errors;

import com.edge1.kamil.nope.rewardsys.view.ApiErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
class ApiErrorHandler {

    @ExceptionHandler({CustomerNotFound.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiErrorDTO handleTransactionNotFoundException(CustomerNotFound cnf) {
        return new ApiErrorDTO("error-0001", "No customer found with ID " + cnf.getMessage());
    }

    @ExceptionHandler({TransactionNotFound.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiErrorDTO handleTransactionNotFoundException(TransactionNotFound tnf) {
        return new ApiErrorDTO("error-0002", "No transaction found with ID " + tnf.getMessage());
    }

    @ExceptionHandler({SystemError.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorDTO handleTransactionNotFoundException(SystemError te) {
        return new ApiErrorDTO("error-0003", "Internal error " + te.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiErrorDTO handleTransactionNotFoundException(MethodArgumentNotValidException te) {
        log.error(te.getMessage());
        return new ApiErrorDTO("error-0004", "Validation error " + te.getMessage());
    }
}