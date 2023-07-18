package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperation;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemRequest;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResponse;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllItemOperationProcessor implements GetAllItemOperation {
    private final ItemRepository itemRepository;

    @Override
    public GetAllItemsResponse process(GetAllItemRequest request) {
        if (request.getShouldIncludeArchived()) {
            return GetAllItemsResponse.builder()
                    .items(this.itemRepository
                            .findAll()
                            .stream()
                            .map(this::mapItemToGetAllItemOperationProcessorSingleItem)
                            .collect(Collectors.toSet()))
                    .build();
        }

        return GetAllItemsResponse.builder()
                .items(this.itemRepository
                        .findAllByIsArchivedFalse()
                        .stream()
                        .map(this::mapItemToGetAllItemOperationProcessorSingleItem)
                        .collect(Collectors.toSet()))
                .build();
    }

    private GetAllItemOperationProcessorSingleItem mapItemToGetAllItemOperationProcessorSingleItem(Item item) {

        return GetAllItemOperationProcessorSingleItem.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getId())
                .multimedia(item.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(item.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .isArchived(item.getIsArchived())
                .build();
    }
}
