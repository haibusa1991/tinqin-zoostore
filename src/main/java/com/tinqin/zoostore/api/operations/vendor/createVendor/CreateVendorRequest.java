package com.tinqin.zoostore.api.operations.vendor.createVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendorRequest implements ProcessorInput {
    private String name;
}
