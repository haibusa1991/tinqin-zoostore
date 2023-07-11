package com.tinqin.zoostore.service.vendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor getVendorByName(String vendorName) {
        return this.vendorRepository.findByName(vendorName);
    }

    @Override
    public Vendor getVendorById(UUID vendorId){
        return this.vendorRepository.getReferenceById(vendorId);
    }
}
