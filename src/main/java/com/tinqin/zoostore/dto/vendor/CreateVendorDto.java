package com.tinqin.zoostore.dto.vendor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateVendorDto {
    private String name;
}
