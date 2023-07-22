package com.tinqin.zoostore.core.exception;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id) {
        super(String.format("Item with id '%s' does not exist.", id));
    }
}
