package com.tinqin.zoostore.core.processor.vendor;

import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdInput;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResult;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetVendorByIdOperationProcessor implements GetVendorByIdOperation {
    private final VendorRepository vendorRepository;

    @Override
    public GetVendorByIdResult process(GetVendorByIdInput input) {
        Vendor vendor = this.vendorRepository.findById(input.getId()).orElseThrow(() -> new VendorNotFoundException(input.getId()));

        return GetVendorByIdResult.builder()
                .id(vendor.getId())
                .name(vendor.getName())
                .build();
    }
}
