package com.edge1.kamil.nope.rewardsys.errors;

public class ValidationError extends RuntimeException {

    public ValidationError(final String message) {
        super(message);
    }
}

