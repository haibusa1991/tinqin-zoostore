package com.tinqin.zoostore.api.operations.item.getAllItem;

import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResponse;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllItemsResponse {

    private Set<GetItemByIdResponse> items;
}
