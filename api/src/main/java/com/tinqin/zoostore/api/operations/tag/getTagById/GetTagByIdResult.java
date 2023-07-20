package com.tinqin.zoostore.api.operations.tag.getTagById;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
public class GetTagByIdResult implements ProcessorResult {

    private UUID id;
    private String name;
}
