package com.tinqin.zoostore.api.operations.item.editItemVendor;

import com.tinqin.zoostore.api.base.ProcessorInput;
import com.tinqin.zoostore.api.operations.item.BaseEditItemInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemVendorInput extends BaseEditItemInput implements ProcessorInput {
    @org.hibernate.validator.constraints.UUID
    private UUID vendorId;
}
