package com.tinqin.zoostore.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public abstract class BaseEditDto {
    private String id;
}
