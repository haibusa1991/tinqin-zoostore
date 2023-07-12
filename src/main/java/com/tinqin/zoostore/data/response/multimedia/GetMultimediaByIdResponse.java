package com.tinqin.zoostore.data.response.multimedia;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetMultimediaByIdResponse {

    private String id;
    private String url;
}
