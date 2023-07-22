package com.tinqin.zoostore.api.operations.multimedia.createMultimedia;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class CreateMultimediaResult implements ProcessorResult {
    private UUID id;
    private String url;
}
