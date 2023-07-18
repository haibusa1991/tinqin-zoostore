package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResponse;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusOperation;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusRequest;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusResponse;
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

public class UpdateArchivedStatusOperationProcessor implements UpdateArchivedStatusOperation {
    private final ItemRepository itemRepository;

    @Override
    public UpdateArchivedStatusResponse process(UpdateArchivedStatusRequest request) {
        Optional<Item> itemOptional = this.itemRepository.findById(UuidValidator.getUuid(request.getId()));

        if (itemOptional.isEmpty()) {
            throw new ItemNotFoundException(request.getId());
        }

        Item item = itemOptional.get();

        item.setIsArchived(request.getArchivedStatus());

        Item persisted = this.itemRepository.save(item);

        return UpdateArchivedStatusResponse.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
