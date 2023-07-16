package com.tinqin.zoostore.service.vendor.getVendor;

import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.response.vendor.GetAllVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface GetVendorService {

    GetVendorByIdResponse getVendorById(String vendorId) throws IdNotFoundException;

    Optional<Vendor> getVendorById(UUID vendorId);

    GetAllVendorResponse getAllVendor();
}
