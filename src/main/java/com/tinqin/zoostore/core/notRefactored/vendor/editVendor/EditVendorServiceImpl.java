//package com.tinqin.zoostore.core.processor.vendor.editVendor;
//
//import com.tinqin.zoostore.persistence.entity.Vendor;
//import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorRequest;
//import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponse;
//import com.tinqin.zoostore.core.exception.IdNotFoundException;
//import com.tinqin.zoostore.core.exception.VendorNotFoundException;
//import com.tinqin.zoostore.persistence.repository.VendorRepository;
//import com.tinqin.zoostore.api.operations.getVendorById.GetVendorByIdOperation;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class EditVendorServiceImpl implements EditVendorService {
//
//    private final VendorRepository vendorRepository;
//    private final GetVendorByIdOperation getVendorService;
//
//
//    @Override
//    public EditVendorResponse editVendor(EditVendorRequest request, String vendorId) throws VendorNotFoundException, IdNotFoundException {
//        Optional<Vendor> vendorOptional = this.getVendorService.getVendorById(UUID.fromString(vendorId));
//
//        if (vendorOptional.isEmpty()){
//            throw new VendorNotFoundException(vendorId);
//        }
//
//        Vendor vendor = vendorOptional.get();
//
//        vendor.setName(request.getName());
//        Vendor persisted = this.vendorRepository.save(vendor);
//
//        return EditVendorResponse.builder()
//                .id(persisted.getId().toString())
//                .name(persisted.getName())
//                .build();
//    }
//}
