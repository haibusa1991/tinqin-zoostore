package com.tinqin.zoostore.api.operations.item.updateArchivedStatus;

import com.tinqin.zoostore.api.base.ProcessorInput;
import com.tinqin.zoostore.api.operations.item.BaseEditItemInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class UpdateArchivedStatusInput  extends BaseEditItemInput implements ProcessorInput {
    private Boolean archivedStatus;
}
