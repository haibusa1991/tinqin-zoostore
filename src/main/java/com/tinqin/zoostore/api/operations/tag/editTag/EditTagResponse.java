package com.tinqin.zoostore.api.operations.tag.editTag;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditTagResponse implements ProcessorResult {
    private UUID id;
    private String name;
}
