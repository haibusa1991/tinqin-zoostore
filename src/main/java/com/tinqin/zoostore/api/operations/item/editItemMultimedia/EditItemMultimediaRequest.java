package com.tinqin.zoostore.api.operations.item.editItemMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemMultimediaRequest implements ProcessorInput {
    private String id;
    private String[] multimediaIds;
}
