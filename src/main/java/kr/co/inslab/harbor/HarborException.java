package kr.co.inslab.harbor;

import org.springframework.http.HttpStatus;

public class HarborException extends Exception{

    private final HttpStatus httpStatus;

    public HarborException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
