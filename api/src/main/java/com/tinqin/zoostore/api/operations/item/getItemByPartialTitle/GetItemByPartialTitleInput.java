package com.tinqin.zoostore.api.operations.item.getItemByPartialTitle;

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
public class GetItemByPartialTitleInput implements ProcessorInput {
    String title;
    Integer itemCount;
    Integer page;
}
