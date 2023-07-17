package com.tinqin.zoostore.api.response.tag;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditTagResponse {
    private String id;
    private String name;
}
