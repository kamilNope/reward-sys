package com.edge1.kamil.nope.rewardsys.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Transaction Not Found")
public class TransactionNotFound extends RuntimeException {

    public TransactionNotFound(final String message) {
        super(message);
    }
}

