package com.tinqin.zoostore.core;

import com.tinqin.zoostore.core.exception.InvalidUuidException;

import java.util.UUID;

public class UuidValidator {
    public static UUID getUuid(String uuid) throws InvalidUuidException {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(uuid);
        }
    }
}
