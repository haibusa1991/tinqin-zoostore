package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionOperation;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionRequest;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionResponse;
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
public class EditItemDescriptionOperationProcessor implements EditItemDescriptionOperation {
    private final ItemRepository itemRepository;

    @Override
    public EditItemDescriptionResponse process(EditItemDescriptionRequest request) {
        Optional<Item> itemOptional = this.itemRepository.findById(UuidValidator.getUuid(request.getId()));

        if (itemOptional.isEmpty()) {
            throw new ItemNotFoundException(request.getId());
        }

        Item item = itemOptional.get();

        item.setTitle(request.getDescription());

        Item persisted = this.itemRepository.save(item);

        return EditItemDescriptionResponse.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
