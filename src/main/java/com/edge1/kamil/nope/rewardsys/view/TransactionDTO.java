package com.edge1.kamil.nope.rewardsys.view;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransactionDTO {

    private Long id;
    @NotNull
    private Double price;
    @Setter
    private Integer rewardPoints;
    @NotNull
    private Long customerId;
}
