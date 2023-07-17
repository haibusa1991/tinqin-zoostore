package com.tinqin.zoostore.api.operations.item.editItemMultimedia;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemMultimediaRequest {
    private String[] multimediaIds;
}
