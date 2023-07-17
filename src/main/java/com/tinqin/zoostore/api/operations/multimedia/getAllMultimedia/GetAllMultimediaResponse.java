package com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResponse;
import com.tinqin.zoostore.core.processor.multimedia.GetAllMultimediaOperationProcessorSingleItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class GetAllMultimediaResponse implements ProcessorResult {

    private List<GetAllMultimediaOperationProcessorSingleItem> multimedia;

}
