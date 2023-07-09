package com.tinqin.zoostore.dto.tag;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class TagDto {
    private String id;
    private String value;
}
