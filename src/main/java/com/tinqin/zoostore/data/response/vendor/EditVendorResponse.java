package com.tinqin.zoostore.data.response.vendor;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditVendorResponse {
    private String id;
    private String name;
}
