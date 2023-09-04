package com.canevi.profile.domain.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseResponse {
    private String message = "";
    private Integer status = HttpStatus.OK.value();

    public void setMessage(String message) {
        this.message = message != null ? message : "";
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }
}
