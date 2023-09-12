package com.canevi.profile.domain.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooleanResponse extends BaseResponse {
    private boolean result;
    public BooleanResponse(boolean result) {
        super();
        this.result = result;
    }
    public BooleanResponse(boolean result, String message) {
        super(message);
        this.result = result;
    }
    public BooleanResponse(boolean result, String message, HttpStatus status) {
        super(message, status);
        this.result = result;
    }
}
