package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagOperation;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagInput;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemTagOperationProcessor implements EditItemTagOperation {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public EditItemTagResult process(EditItemTagInput request) {

        Set<UUID> tagUuids = UuidValidator.getUuid(request.getTagIds());
        for (UUID tagUuid : tagUuids) {
            if (!this.tagRepository.existsById(tagUuid)) {
                throw new TagNotFoundException(tagUuid.toString());
            }
        }

        Set<Tag> tags = this.tagRepository.findAllByIdIn(tagUuids);

        Optional<Item> itemOptional = this.itemRepository.findById(UuidValidator.getUuid(request.getId()));
        if (itemOptional.isEmpty()) {
            throw new ItemNotFoundException(request.getId());
        }
        Item item = itemOptional.get();

        item.setTags(tags);
        Item persisted = this.itemRepository.save(item);

        return EditItemTagResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
