package com.tinqin.zoostore.service.item.createItem;

import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.EditItemTitleResponse;
import com.tinqin.zoostore.exception.VendorNotFoundException;

public interface CreateItemService {
    EditItemTitleResponse createNewItem(CreateNewItemRequest request) throws VendorNotFoundException;
}
