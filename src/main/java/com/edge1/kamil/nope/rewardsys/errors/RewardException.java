package com.edge1.kamil.nope.rewardsys.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Actor Not Found")
public class RewardException extends RuntimeException {

    public RewardException(final String message) {
        super(message);
    }
}

