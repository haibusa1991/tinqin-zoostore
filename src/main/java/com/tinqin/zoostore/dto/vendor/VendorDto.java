package com.tinqin.zoostore.dto.vendor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class VendorDto {
    private String id;
    private String name;
}
