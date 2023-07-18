package com.tinqin.zoostore.core.exception;

public class InvalidUuidException extends RuntimeException {
    public InvalidUuidException(String uuid) {
        super(String.format("'%s' is not a valid UUID.", uuid));
    }
}
