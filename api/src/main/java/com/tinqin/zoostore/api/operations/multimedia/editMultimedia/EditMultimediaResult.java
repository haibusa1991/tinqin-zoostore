package com.tinqin.zoostore.api.operations.multimedia.editMultimedia;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditMultimediaResult implements ProcessorResult {
    private String id;
    private String url;
}
