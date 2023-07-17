package com.tinqin.zoostore.api.response.multimedia;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class CreateMultimediaResponse {
    private String id;
    private String url;
}
