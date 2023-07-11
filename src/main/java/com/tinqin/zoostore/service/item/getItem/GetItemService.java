package com.tinqin.zoostore.service.item.getItem;

import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;

import java.util.List;

public interface GetItemService {
    List<GetAllItemsResponse> getAllItemsResponse();

    GetItemByIdResponse getItemById(String itemId);
}
