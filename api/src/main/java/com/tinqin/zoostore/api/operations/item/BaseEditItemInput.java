package com.tinqin.zoostore.api.operations.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public abstract class BaseEditItemInput {
    @JsonIgnore
    @org.hibernate.validator.constraints.UUID
    private UUID id;
}
