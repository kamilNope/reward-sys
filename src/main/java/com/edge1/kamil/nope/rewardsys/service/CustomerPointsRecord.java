package com.edge1.kamil.nope.rewardsys.service;

import java.util.Objects;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerPointsRecord {
    String customerName;
    Integer customerScore;
}
