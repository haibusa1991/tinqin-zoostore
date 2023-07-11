package com.tinqin.zoostore.service.vendor.editVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;
import com.tinqin.zoostore.repository.VendorRepository;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorServiceImpl implements EditVendorService {

    private final VendorRepository vendorRepository;
    private final GetVendorService getVendorService;


    @Override
    public EditVendorResponse editVendor(EditVendorRequest request) {
        Vendor vendor = this.getVendorService.getVendorById(UUID.fromString(request.getId()));
        vendor.setName(request.getName());
        Vendor persisted = this.vendorRepository.save(vendor);

        return EditVendorResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
