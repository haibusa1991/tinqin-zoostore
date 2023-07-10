package com.tinqin.zoostore.services.item;

import com.tinqin.zoostore.requests.item.CreateNewItemRequest;
import com.tinqin.zoostore.responses.item.CreateNewItemResponse;
import com.tinqin.zoostore.responses.item.GetAllItemsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public CreateNewItemResponse createNewItem(CreateNewItemRequest request) {
        return new CreateNewItemResponse().builder().build();
    }

    @Override
    public ResponseEntity<List<GetAllItemsResponse>> getAllItems() {
        return null;
    }

    @Override
    public void initDatabase() {

    }
}
