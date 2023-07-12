package com.tinqin.zoostore.service.item.getItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GetItemServiceImpl implements GetItemService {
    private final ItemRepository itemRepository;

    public GetItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public GetAllItemsResponse getAllItemsResponse() {

        return GetAllItemsResponse.builder()
                .items(this.itemRepository.findAll().stream().map(this::mapItemToGetItemByIdResponse).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public GetItemByIdResponse getItemById(String itemId) {
        Optional<Item> item = this.itemRepository.findById(UUID.fromString(itemId));

        //TODO add check
        return this.mapItemToGetItemByIdResponse(item.get());
    }

    private GetItemByIdResponse mapItemToGetItemByIdResponse(Item item) {

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
