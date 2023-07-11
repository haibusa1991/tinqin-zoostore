package com.tinqin.zoostore.service.item.createItem;

import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;

public interface CreateItemService {
    CreateNewItemResponse createNewItem(CreateNewItemRequest request);
}
