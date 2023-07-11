package com.tinqin.zoostore.service.item.getItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetItemServiceImpl implements GetItemService {
    private final ItemRepository itemRepository;

    public GetItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<GetAllItemsResponse> getAllItemsResponse() {
        return this.itemRepository.findAll().stream().map(this::mapToGetAllItemsResponse).toList();
    }

    @Override
    public GetItemByIdResponse getItemById(String itemId) {
        Item item = this.itemRepository.getItemById(UUID.fromString(itemId));
        return item == null ? null : mapToGetItemByIdResponse(item);
    }

    private GetAllItemsResponse mapToGetAllItemsResponse(Item item) {

        return GetAllItemsResponse.builder()
                .id(item.getId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendorId().getId().toString())
                .multimedia(item.getMultimediaLinks().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .tags(item.getTags().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .build();
    }

    private GetItemByIdResponse mapToGetItemByIdResponse(Item item) {

        return GetItemByIdResponse.builder()
                .id(item.getId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendorId().getId().toString())
                .multimedia(item.getMultimediaLinks().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .tags(item.getTags().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .build();
    }
}
