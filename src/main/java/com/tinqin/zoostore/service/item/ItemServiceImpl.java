package com.tinqin.zoostore.service.item;

import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;
import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.service.item.createItem.CreateItemService;
import com.tinqin.zoostore.service.item.getItem.GetItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final CreateItemService createItemService;
    private final GetItemService getItemService;


    @Override
    public CreateNewItemResponse createNewItem(CreateNewItemRequest request) {
        return this.createItemService.createNewItem(request);
    }

    @Override
    public List<GetAllItemsResponse> getAllItems() {
       return this.getItemService.getAllItemsResponse();
    }

    @Override
    public GetItemByIdResponse getItemById(String itemId) {
        return this.getItemService.getItemById(itemId);
    }


}
