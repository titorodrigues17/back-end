package com.curiosity.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseFailed {
    private String message;
    private String errorCode;

    public ResponseFailed(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
