package com.tinqin.zoostore.service.item;

import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;
import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;

import java.util.List;

public interface ItemService {
    CreateNewItemResponse createNewItem(CreateNewItemRequest request);

    List<GetAllItemsResponse> getAllItems();

    GetItemByIdResponse getItemById(String itemId);
}
