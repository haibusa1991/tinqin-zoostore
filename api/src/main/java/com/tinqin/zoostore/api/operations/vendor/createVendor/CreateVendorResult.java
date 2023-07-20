package com.tinqin.zoostore.api.operations.vendor.createVendor;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendorResult implements ProcessorResult {
    private String id;
    private String name;
}
