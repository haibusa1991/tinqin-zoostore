package com.tinqin.zoostore.data.response.tag;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class CreateTagResponse {
    private String id;
    private String name;
}
