package com.tinqin.zoostore.data.request.multimedia;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateMultimediaRequest {
    private String url;
}
