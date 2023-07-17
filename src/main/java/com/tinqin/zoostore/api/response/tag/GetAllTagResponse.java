package com.tinqin.zoostore.api.response.tag;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class GetAllTagResponse {
    List<GetTagByIdResponse> tags;
}
