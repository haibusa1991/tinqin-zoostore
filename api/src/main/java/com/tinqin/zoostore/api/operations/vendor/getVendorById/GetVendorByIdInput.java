package com.tinqin.zoostore.api.operations.vendor.getVendorById;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GetVendorByIdInput implements ProcessorInput {
    private String id;
}
