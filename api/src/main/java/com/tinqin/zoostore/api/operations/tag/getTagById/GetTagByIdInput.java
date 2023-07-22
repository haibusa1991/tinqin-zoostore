package com.tinqin.zoostore.api.operations.tag.getTagById;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTagByIdInput implements ProcessorInput {
    private UUID id;
}
