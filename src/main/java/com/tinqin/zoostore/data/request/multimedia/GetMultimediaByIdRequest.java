package com.tinqin.zoostore.data.request.multimedia;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class GetMultimediaByIdRequest {
    private String id;
}