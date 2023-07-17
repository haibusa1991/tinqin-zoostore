package com.tinqin.zoostore.api.operations.item.createItem;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateItemRequest implements ProcessorInput {

    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
