package com.tinqin.zoostore.api.operations.vendor.getVendorById;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdResponse implements ProcessorResult {
    private String id;
    private String name;
}
