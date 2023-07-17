package com.tinqin.zoostore.core.notRefactored.vendor.editVendor;

import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;

public interface EditVendorService {
    EditVendorResponse editVendor(EditVendorRequest request, String vendorId) throws VendorNotFoundException, IdNotFoundException;
}
