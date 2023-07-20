package com.tinqin.zoostore.core.processor.vendor;

import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorInput;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorOperationProcessorSingleItem;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorResult;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllVendorOperationProcessor implements GetAllVendorOperation {
    private final VendorRepository vendorRepository;

    @Override
    public GetAllVendorResult process(GetAllVendorInput input) {
        List<GetAllVendorOperationProcessorSingleItem> list = this.vendorRepository
                .findAll()
                .stream()
                .map(this::mapVendorToSingleItem)
                .toList();

        return GetAllVendorResult.builder().vendors(list).build();

    }

    private GetAllVendorOperationProcessorSingleItem mapVendorToSingleItem(Vendor vendor) {
        return GetAllVendorOperationProcessorSingleItem.builder()
                .id(vendor.getId())
                .name(vendor.getName())
                .build();
    }
}
