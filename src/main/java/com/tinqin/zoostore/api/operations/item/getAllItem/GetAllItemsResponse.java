package com.tinqin.zoostore.api.operations.item.getAllItem;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResponse;
import com.tinqin.zoostore.core.processor.item.GetAllItemOperationProcessorSingleItem;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllItemsResponse implements ProcessorResult {

    private Set<GetAllItemOperationProcessorSingleItem> items;
}
