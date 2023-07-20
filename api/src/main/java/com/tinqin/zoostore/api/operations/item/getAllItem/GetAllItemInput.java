package com.tinqin.zoostore.api.operations.item.getAllItem;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class GetAllItemInput implements ProcessorInput {
    Boolean shouldIncludeArchived;
}
