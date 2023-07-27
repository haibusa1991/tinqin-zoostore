package com.tinqin.zoostore.api.operations.item.getAllItem;

import com.tinqin.zoostore.api.base.ProcessorInput;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class GetAllItemInput implements ProcessorInput {
    Boolean shouldIncludeArchived;
    @Nullable
    UUID tagId;

    Integer itemCount;
    Integer page;
}
