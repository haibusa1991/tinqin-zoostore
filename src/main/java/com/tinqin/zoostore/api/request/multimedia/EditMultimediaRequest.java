package com.tinqin.zoostore.api.request.multimedia;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditMultimediaRequest {
    private String url;
}
