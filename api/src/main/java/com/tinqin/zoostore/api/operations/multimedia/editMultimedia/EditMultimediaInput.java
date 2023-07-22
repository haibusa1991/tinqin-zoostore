package com.tinqin.zoostore.api.operations.multimedia.editMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditMultimediaInput implements ProcessorInput {
    @org.hibernate.validator.constraints.UUID
    private UUID id;
    @NotEmpty
    private String url;
}
