package com.tinqin.zoostore.dto.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemDto {
    private String title;
    private String description;
    private String vendor;
}
