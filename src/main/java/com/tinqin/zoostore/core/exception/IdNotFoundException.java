package com.tinqin.zoostore.core.exception;

public class IdNotFoundException extends Exception{
    public IdNotFoundException() {
        super("Id does not exist.");
    }
}
