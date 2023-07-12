package com.tinqin.zoostore.data.response.multimedia;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class GetAllMultimediaResponse {

    private Set<GetMultimediaByIdResponse> multimedia;

}
