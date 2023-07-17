package com.tinqin.zoostore.api.operations.vendor.editVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditVendorRequest implements ProcessorInput {
    private UUID id;
    private String name;
}
