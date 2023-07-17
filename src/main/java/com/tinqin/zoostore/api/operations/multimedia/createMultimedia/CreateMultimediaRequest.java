package com.tinqin.zoostore.api.operations.multimedia.createMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateMultimediaRequest implements ProcessorInput {
    private String url;
}
