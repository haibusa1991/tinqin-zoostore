package com.tinqin.zoostore.core.notRefactored.vendor.createVendor;

import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResponse;

public interface CreateVendorService {
    CreateVendorResponse createVendor(CreateVendorRequest request);
}
