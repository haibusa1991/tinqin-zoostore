package com.tinqin.zoostore.services.vendor;

import com.tinqin.zoostore.models.Vendor;

public interface VendorService {
    void initVendors();

    Vendor getVendorByName(String vendorName);
}
