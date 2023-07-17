package com.tinqin.zoostore.api.response.multimedia;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class GetAllMultimediaResponse {

    private Set<GetMultimediaByIdResponse> multimedia;

}
