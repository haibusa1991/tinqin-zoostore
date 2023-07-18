package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaOperation;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaRequest;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemMultimediaOperationProcessor implements EditItemMultimediaOperation {
    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public EditItemMultimediaResponse process(EditItemMultimediaRequest request) {

        Set<UUID> multimediaUuids = UuidValidator.getUuid(request.getMultimediaIds());
        for (UUID multimediaUuid : multimediaUuids) {
            if (!this.multimediaRepository.existsById(multimediaUuid)) {
                throw new MultimediaNotFoundException(multimediaUuid.toString());
            }
        }

        Set<Multimedia> multimedia = this.multimediaRepository.findAllByIdIn(multimediaUuids);

        Optional<Item> itemOptional = this.itemRepository.findById(UuidValidator.getUuid(request.getId()));
        if (itemOptional.isEmpty()) {
            throw new ItemNotFoundException(request.getId());
        }
        Item item = itemOptional.get();

        item.setMultimedia(multimedia);
        Item persisted = this.itemRepository.save(item);

        return EditItemMultimediaResponse.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
