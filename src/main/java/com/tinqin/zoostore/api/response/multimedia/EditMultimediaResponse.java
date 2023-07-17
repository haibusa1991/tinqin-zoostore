package com.tinqin.zoostore.api.response.multimedia;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditMultimediaResponse {
    private String id;
    private String url;
}
