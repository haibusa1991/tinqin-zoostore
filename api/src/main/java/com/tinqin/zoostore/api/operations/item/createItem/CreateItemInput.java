package com.tinqin.zoostore.api.operations.item.createItem;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
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
