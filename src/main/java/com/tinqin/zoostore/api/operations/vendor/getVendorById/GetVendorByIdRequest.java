package com.tinqin.zoostore.api.operations.vendor.getVendorById;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GetVendorByIdRequest implements ProcessorInput {
    private String id;
}
