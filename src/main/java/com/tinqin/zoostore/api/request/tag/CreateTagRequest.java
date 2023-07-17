package com.tinqin.zoostore.api.request.tag;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateTagRequest {
    private String name;
}
