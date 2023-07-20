package com.tinqin.zoostore.api.operations.tag.createTag;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateTagInput implements ProcessorInput {
    private String name;
}
