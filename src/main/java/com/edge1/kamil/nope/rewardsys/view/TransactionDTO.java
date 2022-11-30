package com.edge1.kamil.nope.rewardsys.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransactionDTO {

    private Long id;
    @NotNull
    private Double price;
    @NotNull
    private Long customerId;
}
