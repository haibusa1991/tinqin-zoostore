package com.tinqin.zoostore.api.operations.item.getAllItem;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllItemsResult implements ProcessorResult {

    private Set<GetAllItemOperationProcessorSingleItem> items;
}
