package com.tinqin.zoostore.api.operations.item.editItemVendor;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditItemVendorResult implements ProcessorResult {

    private UUID id;
    private String title;
    private String description;
    private UUID vendorId;
    private UUID[] multimedia;
    private UUID[] tags;
}
