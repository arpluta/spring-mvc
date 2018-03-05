package pl.spring.demo.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Error {

    private String error;

    @JsonIgnore
    private Date ignoredDate;

    private Date nonIgnoredDate;

    public Error(String error) {
        this.error = error;
        this.ignoredDate = new Date();
        this.nonIgnoredDate = new Date();
    }

    public String getError() {
        return error;
    }

    public void setError(String message) {
        this.error = message;
    }

    public Date getIgnoredDate() {
        return ignoredDate;
    }

    public void setIgnoredDate(Date ignoredDate) {
        this.ignoredDate = ignoredDate;
    }

    public Date getNonIgnoredDate() {
        return nonIgnoredDate;
    }

    public void setNonIgnoredDate(Date nonIgnoredDate) {
        this.nonIgnoredDate = nonIgnoredDate;
    }
}
