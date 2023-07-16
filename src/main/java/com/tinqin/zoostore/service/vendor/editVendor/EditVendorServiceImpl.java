package com.tinqin.zoostore.service.vendor.editVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import com.tinqin.zoostore.repository.VendorRepository;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorServiceImpl implements EditVendorService {

    private final VendorRepository vendorRepository;
    private final GetVendorService getVendorService;


    @Override
    public EditVendorResponse editVendor(EditVendorRequest request, String vendorId) throws VendorNotFoundException, IdNotFoundException {
        Optional<Vendor> vendorOptional = this.getVendorService.getVendorById(UUID.fromString(vendorId));

        if (vendorOptional.isEmpty()){
            throw new VendorNotFoundException();
        }

        Vendor vendor = vendorOptional.get();

        vendor.setName(request.getName());
        Vendor persisted = this.vendorRepository.save(vendor);

        return EditVendorResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
