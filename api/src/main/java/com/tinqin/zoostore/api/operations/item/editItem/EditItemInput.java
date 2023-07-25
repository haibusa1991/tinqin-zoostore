package com.tinqin.zoostore.api.operations.item.editItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EditItemInput implements ProcessorInput {

    @org.hibernate.validator.constraints.UUID
    @JsonIgnore
    private String id;

    @Nullable
    private String title;

    @Nullable
    private String description;

    @Nullable
    @org.hibernate.validator.constraints.UUID
    private String vendorId;

    @Nullable
    @org.hibernate.validator.constraints.UUID
    private Set<String> multimedia;

    @Nullable
    @org.hibernate.validator.constraints.UUID
    private Set<String> tags;

    @Nullable
    private Boolean isArchived;
}
