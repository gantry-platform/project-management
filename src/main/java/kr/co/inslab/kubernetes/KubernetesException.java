package kr.co.inslab.kubernetes;

import org.springframework.http.HttpStatus;

public class KubernetesException extends Exception{

    private final HttpStatus httpStatus;

    public KubernetesException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
