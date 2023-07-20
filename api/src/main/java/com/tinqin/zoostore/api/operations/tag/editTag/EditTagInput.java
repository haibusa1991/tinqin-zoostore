package com.tinqin.zoostore.api.operations.tag.editTag;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditTagInput implements ProcessorInput {
    private String id;
    private String name;
}
