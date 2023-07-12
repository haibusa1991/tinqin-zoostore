package com.tinqin.zoostore.data.request.tag;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class CreateTagRequest {
    private String name;
}
