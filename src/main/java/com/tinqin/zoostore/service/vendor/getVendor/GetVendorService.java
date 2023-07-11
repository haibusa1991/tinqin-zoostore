package com.tinqin.zoostore.service.vendor.getVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.vendor.GetVendorByIdRequest;
import com.tinqin.zoostore.data.response.vendor.GetAllVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;

import java.util.UUID;

public interface GetVendorService {

    GetVendorByIdResponse getVendorById(GetVendorByIdRequest request);

    Vendor getVendorById(UUID vendorId);

    GetAllVendorResponse getAllVendor();
}
