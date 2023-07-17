package com.tinqin.zoostore.api.operations.multimedia.createMultimedia;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class CreateMultimediaResponse implements ProcessorResult {
    private String id;
    private String url;
}
