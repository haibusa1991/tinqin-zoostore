package com.tinqin.zoostore.api.response.tag;

import lombok.*;

@Getter
@Setter
@Builder
public class GetTagByIdResponse {

    private String id;
    private String name;
}
