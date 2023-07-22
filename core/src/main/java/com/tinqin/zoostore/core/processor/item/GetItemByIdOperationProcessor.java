package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdOperation;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdInput;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResult;
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

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {
    private final ItemRepository itemRepository;

    @Override
    public GetItemByIdResult process(GetItemByIdInput input) {

        Item item = this.itemRepository.findById(input.getId()).orElseThrow(() -> new ItemNotFoundException(input.getId()));

        return GetItemByIdResult.builder()
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
