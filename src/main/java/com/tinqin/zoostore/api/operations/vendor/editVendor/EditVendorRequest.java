package com.tinqin.zoostore.api.operations.vendor.editVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class EditVendorRequest implements ProcessorInput {
    private String id;
    private String name;
}
