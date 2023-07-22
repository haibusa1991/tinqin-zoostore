package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleOperation;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleInput;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResult;
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
public class EditItemTitleOperationProcessor implements EditItemTitleOperation {
    private final ItemRepository itemRepository;

    @Override
    public EditItemTitleResult process(EditItemTitleInput input) {
        Item item = this.itemRepository.findById(input.getId()).orElseThrow(() -> new ItemNotFoundException(input.getId()));

        item.setTitle(input.getTitle());

        Item persisted = this.itemRepository.save(item);

        return EditItemTitleResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
