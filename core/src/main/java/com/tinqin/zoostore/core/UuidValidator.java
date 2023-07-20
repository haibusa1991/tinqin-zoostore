package com.tinqin.zoostore.core;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UuidValidator {
    public static UUID getUuid(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
//            throw new InvalidUuidException(uuid);
        }
        return null;
    }

    public static Set<UUID> getUuid(String[] uuids) {
        Set<UUID> uuidSet = new HashSet<>();
        for (String uuid : uuids) {
            uuidSet.add(UuidValidator.getUuid(uuid));
        }
        return uuidSet;
    }
}
