package com.tinqin.zoostore.api.operations.multimedia.getMultimediaById;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class GetMultimediaByIdResponse implements ProcessorResult {

    private UUID id;
    private String url;
}
