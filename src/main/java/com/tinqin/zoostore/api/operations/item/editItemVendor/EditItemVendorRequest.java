package com.tinqin.zoostore.api.operations.item.editItemVendor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemVendorRequest {
    private String vendorId;
}
