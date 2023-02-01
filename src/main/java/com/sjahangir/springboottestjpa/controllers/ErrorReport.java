package com.sjahangir.springboottestjpa.controllers;

import java.util.Date;
import java.util.List;

public class ErrorReport {

    private Date timestamp;
    private String message;
    private List<String> details;

    public ErrorReport() {
    }

    public ErrorReport(final Date timestamp, final String message, final List<String> details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(final List<String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorReport{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}
