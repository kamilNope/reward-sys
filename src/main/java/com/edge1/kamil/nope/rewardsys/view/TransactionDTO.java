package com.edge1.kamil.nope.rewardsys.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransactionDTO {
    private Long id;
    private Double price;
    private Long customerId;
}
