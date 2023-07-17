package com.tinqin.zoostore.core.notRefactored.item.getItem;

import com.tinqin.zoostore.api.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.api.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;

public interface GetItemService {
    GetAllItemsResponse getAllItemsResponse(Boolean includeArchived);

    GetItemByIdResponse getItemById(String itemId) throws IdNotFoundException;
}
