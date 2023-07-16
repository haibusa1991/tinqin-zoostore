package com.tinqin.zoostore.service.item.getItem;

import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;

public interface GetItemService {
    GetAllItemsResponse getAllItemsResponse(Boolean includeArchived);

    GetItemByIdResponse getItemById(String itemId) throws IdNotFoundException;
}
