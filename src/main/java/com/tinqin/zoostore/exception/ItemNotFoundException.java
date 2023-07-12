package com.tinqin.zoostore.exception;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super("Item id does not exist.");
    }
}
