package com.tinqin.zoostore.api.operations.item.createItem;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateItemInput implements ProcessorInput {

    private String title;
    private String description;
    @org.hibernate.validator.constraints.UUID
    private UUID vendorId;
    @org.hibernate.validator.constraints.UUID
    private Set<UUID> multimedia;
    @org.hibernate.validator.constraints.UUID
    private Set<UUID> tags;
}
