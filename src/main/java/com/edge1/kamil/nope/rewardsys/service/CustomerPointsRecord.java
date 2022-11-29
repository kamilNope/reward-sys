package com.edge1.kamil.nope.rewardsys.service;

import java.util.Objects;

public class CustomerPointsRecord {

    public Double userScore;
    public String userID;

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomerPointsRecord that = (CustomerPointsRecord) o;
        return Objects.equals(getUserScore(), that.getUserScore()) && Objects.equals(getUserID(),
                that.getUserID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserScore(), getUserID());
    }
}
