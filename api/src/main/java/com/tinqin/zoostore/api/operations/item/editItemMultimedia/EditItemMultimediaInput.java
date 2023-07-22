package com.tinqin.zoostore.api.operations.item.editItemMultimedia;

import com.tinqin.zoostore.api.base.ProcessorInput;
import com.tinqin.zoostore.api.operations.item.BaseEditItemInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemMultimediaInput extends BaseEditItemInput implements ProcessorInput {
    @org.hibernate.validator.constraints.UUID
    private Set<UUID> multimediaIds;
}
