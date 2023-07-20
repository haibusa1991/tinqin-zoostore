package com.tinqin.zoostore.api.operations.multimedia.editMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditMultimediaInput implements ProcessorInput {
    private String id;
    private String url;
}
