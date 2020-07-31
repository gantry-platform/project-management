package kr.co.inslab.route53;

import org.springframework.http.HttpStatus;

public class Route53Exception extends Exception{

    private final HttpStatus httpStatus;

    public Route53Exception(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
