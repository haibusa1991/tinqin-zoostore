package com.tinqin.zoostore.data.response.tag;

import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;
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
