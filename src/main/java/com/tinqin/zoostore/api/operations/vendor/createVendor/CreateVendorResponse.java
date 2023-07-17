package com.tinqin.zoostore.api.operations.vendor.createVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendorResponse implements ProcessorResult {
    private String id;
    private String name;
}
