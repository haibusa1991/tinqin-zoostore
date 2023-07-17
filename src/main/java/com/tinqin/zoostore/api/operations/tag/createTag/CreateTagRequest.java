package com.tinqin.zoostore.api.operations.tag.createTag;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateTagRequest implements ProcessorInput {
    private String name;
}
