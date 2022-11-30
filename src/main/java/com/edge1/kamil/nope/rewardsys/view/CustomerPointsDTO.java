package com.edge1.kamil.nope.rewardsys.view;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerPointsDTO {

    @NotNull
    @NotEmpty
    String customerName;
    @NotNull
    Integer customerScore;
}
