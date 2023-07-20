package com.tinqin.zoostore.api.operations.tag.getAllTag;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class GetAllTagOperationProcessorSingleItem {
    private UUID id;
    private String name;
}
