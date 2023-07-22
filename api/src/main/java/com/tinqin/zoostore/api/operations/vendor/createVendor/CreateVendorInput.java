package com.tinqin.zoostore.api.operations.vendor.createVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendorInput implements ProcessorInput {
    @NotEmpty
    private String name;
}
