package com.tinqin.zoostore.exception;

public class IdNotFoundException extends Exception{
    public IdNotFoundException() {
        super("Id does not exist.");
    }
}
