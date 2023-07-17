package com.tinqin.zoostore.core.processor.vendor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class GetAllVendorOperationProcessorSingleItem {
    private UUID id;
    private String name;
}
