package com.tinqin.zoostore.service.item.getItem;

import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import org.springframework.http.ResponseEntity;

public interface GetItemService {
    GetAllItemsResponse getAllItemsResponse();

    GetItemByIdResponse getItemById(String itemId);
}
