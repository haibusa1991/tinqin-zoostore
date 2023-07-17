package com.tinqin.zoostore.api.operations.item.updateArchivedStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class UpdateArchivedStatusRequest {
    private String vendorId;
}
