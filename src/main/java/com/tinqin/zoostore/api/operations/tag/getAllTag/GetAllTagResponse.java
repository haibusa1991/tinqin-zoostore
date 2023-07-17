package com.tinqin.zoostore.api.operations.tag.getAllTag;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.core.processor.tag.GetAllTagOperationProcessorSingleItem;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class GetAllTagResponse implements ProcessorResult {
    List<GetAllTagOperationProcessorSingleItem> tags;
}
