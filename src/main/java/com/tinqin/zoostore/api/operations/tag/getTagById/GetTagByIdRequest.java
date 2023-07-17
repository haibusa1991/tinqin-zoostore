package com.tinqin.zoostore.api.operations.tag.getTagById;

import com.tinqin.zoostore.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTagByIdRequest implements ProcessorInput {
    private String id;
}
