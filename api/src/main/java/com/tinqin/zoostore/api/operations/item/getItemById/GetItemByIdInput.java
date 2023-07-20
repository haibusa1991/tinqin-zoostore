package com.tinqin.zoostore.api.operations.item.getItemById;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class GetItemByIdInput implements ProcessorInput {
    private String id;
}
