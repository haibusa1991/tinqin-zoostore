package com.tinqin.zoostore.api.operations.vendor.createVendor;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendorResult implements ProcessorResult {
    private UUID id;
    private String name;
}
