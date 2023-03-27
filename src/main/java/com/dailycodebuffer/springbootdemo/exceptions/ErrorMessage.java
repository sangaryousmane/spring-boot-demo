package com.dailycodebuffer.springbootdemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {

    private HttpStatus status;
    private String message;
    private Throwable throwable;

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
