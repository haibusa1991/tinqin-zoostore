package com.tinqin.zoostore.api.operations.item.updateArchivedStatus;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class UpdateArchivedStatusInput implements ProcessorInput {
    private String id;
    private Boolean archivedStatus;
}
