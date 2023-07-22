package com.tinqin.zoostore.api.operations.vendor.getVendorById;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdResult implements ProcessorResult {
    private UUID id;
    private String name;
}
