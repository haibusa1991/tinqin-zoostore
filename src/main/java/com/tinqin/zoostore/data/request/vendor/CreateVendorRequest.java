package com.tinqin.zoostore.data.request.vendor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateVendorRequest {
    private String name;
}
