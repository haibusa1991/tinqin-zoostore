package com.tinqin.zoostore.services.vendor;

import com.tinqin.zoostore.models.Vendor;
import com.tinqin.zoostore.repositories.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void initVendors() {
        if (this.vendorRepository.count() > 0) {
            return;
        }
        this.vendorRepository.save(Vendor.builder().name("Whiskas").build());
    }

    @Override
    public Vendor getVendorByName(String vendorName) {
        return this.vendorRepository.findByName(vendorName);
    }
}
