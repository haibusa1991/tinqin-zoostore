package com.tinqin.zoostore.core.exception;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String id) {
        super(String.format("Item with id '%s' does not exist.", id));
    }
}
