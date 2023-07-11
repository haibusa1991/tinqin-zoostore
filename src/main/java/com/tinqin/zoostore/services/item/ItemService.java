package com.tinqin.zoostore.services.item;

import com.tinqin.zoostore.requests.item.CreateNewItemRequest;
import com.tinqin.zoostore.responses.item.CreateNewItemResponse;
import com.tinqin.zoostore.responses.item.GetAllItemsResponse;
import com.tinqin.zoostore.responses.item.GetItemByIdResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemService {
    CreateNewItemResponse createNewItem(CreateNewItemRequest request);

    List<GetAllItemsResponse> getAllItems();

    void initItems();

    GetItemByIdResponse getItemById(String itemId);
}
