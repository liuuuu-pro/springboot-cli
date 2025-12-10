package com.boot.cli.common.core.exception;

public class ServiceException extends RuntimeException {

    public static final int code = 500;

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
