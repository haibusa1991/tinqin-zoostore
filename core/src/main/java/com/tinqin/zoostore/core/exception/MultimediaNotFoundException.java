package com.tinqin.zoostore.core.exception;

import java.util.UUID;

public class MultimediaNotFoundException extends RuntimeException{
    public MultimediaNotFoundException(UUID id) {
        super(String.format("Multimedia with id '%s' does not exist.", id));
    }

    public MultimediaNotFoundException(String idList) {
        super(String.format("Multimedia with id '%s' does not exist.", idList));
    }
}
