package com.tinqin.zoostore.api.operations.item.editItemDescription;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemDescriptionRequest implements ProcessorInput {
    private String id;
    private String description;
}
