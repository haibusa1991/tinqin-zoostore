package com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class GetAllMultimediaOperationProcessorSingleItem {
    private UUID id;
    private String url;
}
