package com.tinqin.zoostore.api.operations.item.editItemDescription;

import com.tinqin.zoostore.api.base.ProcessorInput;
import com.tinqin.zoostore.api.operations.item.BaseEditItemInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemDescriptionInput extends BaseEditItemInput implements ProcessorInput {
    @NotEmpty
    private String description;
}
