package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperation;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemInput;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperationProcessorSingleItem;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResult;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllItemOperationProcessor implements GetAllItemOperation {
    private final ItemRepository itemRepository;

    @Override
    public GetAllItemsResult process(GetAllItemInput input) {
        Set<Item> result = this.itemRepository.findAllByIsArchivedEquals(false);

        if (input.getShouldIncludeArchived()) {
            result.addAll(this.itemRepository.findAllByIsArchivedEquals(true));
        }

        return GetAllItemsResult.builder()
                .items(result.stream()
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
