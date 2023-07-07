package com.tinqin.zoostore.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateItemDto {

    private String title;
    private String description;
    private String vendor;
    private String[] multimedia;
    private String[] tags;
}
