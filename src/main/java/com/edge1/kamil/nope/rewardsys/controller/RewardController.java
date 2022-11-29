package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.service.CustomerPointsRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
@RequestMapping("api/reward-program")
class RewardController {

    @GetMapping("/{userId}")
    CustomerPointsRecord getUserMonthScore(@PathVariable String userId){
        return new CustomerPointsRecord();
    }

}