package com.tinqin.zoostore.core.processor.vendor;

import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorInput;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponseResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditVendorOperationProcessor implements EditVendorOperation {
    private final VendorRepository vendorRepository;

    @Override
    public EditVendorResponseResult process(EditVendorInput input) {
        Vendor vendor = this.vendorRepository.findById(input.getId()).orElseThrow(()->new VendorNotFoundException(input.getId()));

        vendor.setName(input.getName());
        Vendor persisted = this.vendorRepository.save(vendor);

        return EditVendorResponseResult.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    }

}
