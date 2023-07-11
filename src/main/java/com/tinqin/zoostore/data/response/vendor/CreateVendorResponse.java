package com.tinqin.zoostore.data.response.vendor;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class CreateVendorResponse {
    private String id;
    private String name;
}
