package com.tinqin.zoostore.api.operations.vendor.getAllVendor;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.core.processor.vendor.GetAllVendorOperationProcessorSingleItem;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class GetAllVendorResponse implements ProcessorResult {
    List<GetAllVendorOperationProcessorSingleItem> vendors;
}
