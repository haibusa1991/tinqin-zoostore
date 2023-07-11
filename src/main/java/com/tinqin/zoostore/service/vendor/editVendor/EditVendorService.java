package com.tinqin.zoostore.service.vendor.editVendor;

import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;

public interface EditVendorService {
    EditVendorResponse editVendor(EditVendorRequest request);
}
