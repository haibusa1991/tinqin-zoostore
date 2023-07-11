package com.tinqin.zoostore.service.vendor.createVendor;

import com.tinqin.zoostore.data.request.vendor.CreateVendorRequest;
import com.tinqin.zoostore.data.response.vendor.CreateVendorResponse;

public interface CreateVendorService {
    CreateVendorResponse createVendor(CreateVendorRequest request);
}
