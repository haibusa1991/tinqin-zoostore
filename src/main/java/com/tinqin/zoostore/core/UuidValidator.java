package com.tinqin.zoostore.core;

import com.tinqin.zoostore.core.exception.InvalidUuidException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UuidValidator {
    public static UUID getUuid(String uuid) throws InvalidUuidException {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(uuid);
        }
    }

    public static Set<UUID> getUuid(String[] uuids) throws InvalidUuidException {
        Set<UUID> uuidSet = new HashSet<>();
        for (String uuid : uuids) {
            uuidSet.add(UuidValidator.getUuid(uuid));
        }
        return uuidSet;
    }
}
