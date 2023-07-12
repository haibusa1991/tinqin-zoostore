package com.tinqin.zoostore.data.response.item;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllItemsResponse {

    private Set<GetItemByIdResponse> items;
}
