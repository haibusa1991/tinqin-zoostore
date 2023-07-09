package com.tinqin.zoostore.dto.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateItemDto {

    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
