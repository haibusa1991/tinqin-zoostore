package com.tinqin.zoostore.service.vendor.createVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.vendor.CreateVendorRequest;
import com.tinqin.zoostore.data.response.vendor.CreateVendorResponse;
import com.tinqin.zoostore.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateVendorServiceImpl implements CreateVendorService {

    private final VendorRepository vendorRepository;

    @Override
    public CreateVendorResponse createVendor(CreateVendorRequest request) {
        Vendor persisted = this.vendorRepository.save(Vendor.builder().name(request.getName()).build());

        return CreateVendorResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
