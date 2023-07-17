package com.tinqin.zoostore.core.processor.vendor;

import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdRequest;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
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
    public GetVendorByIdResponse process(GetVendorByIdRequest request) throws VendorNotFoundException, InvalidUuidException {
        return this.mapVendorToGetVendorByIdResponse(this.getVendorAndValidate(request.getId()));
    }

    private GetVendorByIdResponse mapVendorToGetVendorByIdResponse(Vendor vendor) {
        return GetVendorByIdResponse.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .build();
    }

    private Vendor getVendorAndValidate(String vendorId) throws InvalidUuidException, VendorNotFoundException {
        UUID vendorUuid = UuidValidator.getUuid(vendorId);

        Optional<Vendor> vendorOptional = this.vendorRepository
                .findById(vendorUuid);

        if (vendorOptional.isEmpty()) {
            throw new VendorNotFoundException(vendorId);
        }

        return vendorOptional.get();
    }


}
