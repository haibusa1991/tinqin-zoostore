package com.tinqin.zoostore.services.item;

import com.tinqin.zoostore.requests.item.CreateNewItemRequest;
import com.tinqin.zoostore.responses.item.CreateNewItemResponse;
import com.tinqin.zoostore.responses.item.GetAllItemsResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    CreateNewItemResponse createNewItem(CreateNewItemRequest request);

    ResponseEntity<List<GetAllItemsResponse>> getAllItems();

    void initDatabase();
}
