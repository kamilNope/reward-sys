package com.edge1.kamil.nope.rewardsys.errors;

public class TransactionNotFound extends RuntimeException {

    public TransactionNotFound(final String message) {
        super(message);
    }
}

