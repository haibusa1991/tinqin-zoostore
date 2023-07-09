package com.tinqin.zoostore.dto.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class ItemTagsDto {
    private String[] tagIds;
}
