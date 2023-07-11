package com.tinqin.zoostore.data.request.vendor;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class GetVendorByIdRequest {
    private String id;
}
