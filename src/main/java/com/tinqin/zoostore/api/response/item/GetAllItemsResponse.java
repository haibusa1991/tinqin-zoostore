package com.tinqin.zoostore.api.response.item;

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
