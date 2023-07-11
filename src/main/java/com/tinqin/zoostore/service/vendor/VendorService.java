package com.tinqin.zoostore.service.vendor;

import com.tinqin.zoostore.data.entity.Vendor;

import java.util.UUID;

public interface VendorService {
    void initVendors();

    Vendor getVendorByName(String vendorName);

    Vendor getVendorById(UUID vendorId);
}
