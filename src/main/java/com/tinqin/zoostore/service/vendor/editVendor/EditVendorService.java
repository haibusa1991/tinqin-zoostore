package com.tinqin.zoostore.service.vendor.editVendor;

import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;

public interface EditVendorService {
    EditVendorResponse editVendor(EditVendorRequest request, String vendorId) throws VendorNotFoundException, IdNotFoundException;
}
