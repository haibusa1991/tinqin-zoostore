package com.tinqin.zoostore.api.operations.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
public abstract class BaseEditItemInput {
    @org.hibernate.validator.constraints.UUID
    private UUID id;
}
