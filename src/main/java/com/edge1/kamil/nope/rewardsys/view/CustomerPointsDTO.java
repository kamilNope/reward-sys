package com.edge1.kamil.nope.rewardsys.view;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerPointsDTO {
    String customerName;
    Integer customerScore;
}
