package com.edge1.kamil.nope.rewardsys.service;

import java.util.Objects;

public class CustomerPointsRecord {

    Double totalUserScore;
    Double monthUserScore;
    String userID;

    public Double getMonthUserScore() {
        return monthUserScore;
    }

    public void setMonthUserScore(Double monthUserScore) {
        this.monthUserScore = monthUserScore;
    }

    public Double getTotalUserScore() {
        return totalUserScore;
    }

    public void setTotalUserScore(Double totalUserScore) {
        this.totalUserScore = totalUserScore;
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
        if (!(o instanceof CustomerPointsRecord))
            return false;
        CustomerPointsRecord that = (CustomerPointsRecord) o;
        return Objects.equals(getTotalUserScore(), that.getTotalUserScore()) && Objects.equals(
                getMonthUserScore(), that.getMonthUserScore()) && Objects.equals(getUserID(), that.getUserID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalUserScore(), getMonthUserScore(), getUserID());
    }
}