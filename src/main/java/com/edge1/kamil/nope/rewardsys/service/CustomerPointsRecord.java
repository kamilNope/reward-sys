package com.edge1.kamil.nope.rewardsys.service;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public final class CustomerPointsRecord {

    Integer totalUserScore;
    Integer monthUserScore;
    String userID;
}
