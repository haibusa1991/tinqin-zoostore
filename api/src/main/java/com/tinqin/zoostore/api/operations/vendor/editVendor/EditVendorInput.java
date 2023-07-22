package com.tinqin.zoostore.api.operations.vendor.editVendor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class EditVendorInput implements ProcessorInput {
    @JsonIgnore
    private UUID id;
    @NotEmpty
    private String name;
}
