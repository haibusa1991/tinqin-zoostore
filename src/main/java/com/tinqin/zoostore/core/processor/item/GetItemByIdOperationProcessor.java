package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResponse;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdOperation;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdRequest;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {
    private final ItemRepository itemRepository;

    @Override
    public GetItemByIdResponse process(GetItemByIdRequest request) {
        Optional<Item> itemOptional = this.itemRepository.findById(UuidValidator.getUuid(request.getId()));
        if (itemOptional.isEmpty()) {
            throw new ItemNotFoundException(request.getId());
        }
        Item item = itemOptional.get();

        return GetItemByIdResponse.builder()
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
