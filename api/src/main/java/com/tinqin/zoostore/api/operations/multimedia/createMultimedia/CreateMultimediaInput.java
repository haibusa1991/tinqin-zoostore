package com.tinqin.zoostore.api.operations.multimedia.createMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateMultimediaInput implements ProcessorInput {
    @NotEmpty
    private String url;
}
