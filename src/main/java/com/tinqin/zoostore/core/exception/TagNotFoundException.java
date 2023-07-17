package com.tinqin.zoostore.core.exception;

public class TagNotFoundException extends Exception{
    public TagNotFoundException(String id) {
        super(String.format("Tag with id '%s' does not exist.", id));
    }
}
