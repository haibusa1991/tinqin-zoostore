package com.tinqin.zoostore.api.operations.item.editItemTag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemTagRequest {
    private String[] tagIds;
}
