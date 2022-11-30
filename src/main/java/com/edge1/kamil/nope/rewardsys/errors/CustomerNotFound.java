package com.edge1.kamil.nope.rewardsys.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound(final String message) {
        super(message);
    }
}
