package com.tinqin.zoostore.data.response.tag;

import lombok.*;

@Getter
@Setter
@Builder
public class GetTagByIdResponse {

    private String id;
    private String name;
}
