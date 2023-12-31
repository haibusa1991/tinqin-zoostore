package com.tinqin.zoostore.core.processor.vendor;

import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorInput;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResult;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVendorOperationProcessor implements CreateVendorOperation {
    private final VendorRepository vendorRepository;

    @Override
    public CreateVendorResult process(CreateVendorInput input) {
        Vendor persisted = this.vendorRepository.save(Vendor.builder().name(input.getName()).build());

        return CreateVendorResult.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    
    }
}
