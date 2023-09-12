package com.canevi.profile.domain.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseResponse {
    private String message;
    private Integer status;
    private Date timestamp;

    public BaseResponse() {
        this("", HttpStatus.OK);
    }

    public BaseResponse(String message) {
        this(message, HttpStatus.OK);
    }

    public BaseResponse(String message, HttpStatus status) {
        setMessage(message);
        setStatus(status);
        timestamp = new Date();
    }

    public void setMessage(String message) {
        this.message = message != null ? message : "";
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }
}
