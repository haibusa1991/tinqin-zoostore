package com.tinqin.zoostore.service.vendor.getVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.vendor.GetVendorByIdRequest;
import com.tinqin.zoostore.data.response.vendor.GetAllVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;
import com.tinqin.zoostore.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetVendorServiceImpl implements GetVendorService {
    private final VendorRepository vendorRepository;

    @Override
    public GetVendorByIdResponse getVendorById(GetVendorByIdRequest request) {
        Vendor vendor = this.vendorRepository
                .getReferenceById(UUID.fromString(request.getId()));

        return this.mapVendorToGetVendorByIdResponse(vendor);
    }

    @Override
    public Vendor getVendorById(UUID vendorId) {
        return this.vendorRepository.getReferenceById(vendorId);
    }

    @Override
    public GetAllVendorResponse getAllVendor() {
        List<GetVendorByIdResponse> allVendors = this.vendorRepository
                .findAll()
                .stream()
                .map(this::mapVendorToGetVendorByIdResponse)
                .toList();

        return GetAllVendorResponse.builder()
                .vendors(allVendors)
                .build();
    }

    private GetVendorByIdResponse mapVendorToGetVendorByIdResponse(Vendor vendor) {
        return GetVendorByIdResponse.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .build();
    }
}
