package com.tinqin.zoostore.core.exception;

public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(String id) {
        super(String.format("Tag with id '%s' does not exist.", id));
    }
}
