package com.tinqin.zoostore.api.operations.item;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEditItemResult {
    private UUID id;
    private String title;
    private String description;
    private UUID vendorId;
    private UUID[] multimedia;
    private UUID[] tags;
    private Boolean isArchived;
}
