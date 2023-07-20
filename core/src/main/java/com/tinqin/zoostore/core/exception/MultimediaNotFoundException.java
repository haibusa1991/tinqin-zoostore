package com.tinqin.zoostore.core.exception;

public class MultimediaNotFoundException extends RuntimeException{
    public MultimediaNotFoundException(String id) {
        super(String.format("Multimedia with id '%s' does not exist.", id));
    }
}
