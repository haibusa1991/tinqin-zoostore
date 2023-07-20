package com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetAllMultimediaResult implements ProcessorResult {

    private List<GetAllMultimediaOperationProcessorSingleItem> multimedia;

}
