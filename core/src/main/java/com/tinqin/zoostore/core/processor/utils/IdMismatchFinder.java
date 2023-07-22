package com.tinqin.zoostore.core.processor.utils;

import com.tinqin.zoostore.persistence.entity.BaseEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class IdMismatchFinder {

    public static String find(Set<? extends BaseEntity> found, Set<UUID> target) {

        List<String> targetList = target.stream()
                .map(UUID::toString)
                .toList();

        return found.stream()
                .map(BaseEntity::getId)
                .map(UUID::toString)
                .filter(e -> !targetList.contains(e))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
