package com.tinqin.zoostore.api.operations.tag.editTag;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EditTagInput implements ProcessorInput {
    @JsonIgnore
    private UUID id;
    @NotEmpty
    private String name;
}
