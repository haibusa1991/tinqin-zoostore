package com.tinqin.zoostore.data.request.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemDescriptionRequest {
    private String description;
}
