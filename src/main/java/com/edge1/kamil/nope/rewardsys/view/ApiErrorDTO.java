package com.edge1.kamil.nope.rewardsys.view;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiErrorDTO {
    private String error;
    private String message;
}
