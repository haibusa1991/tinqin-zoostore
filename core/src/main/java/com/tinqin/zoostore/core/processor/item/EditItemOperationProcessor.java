package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItem.EditItemInput;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemOperation;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemResult;
import com.tinqin.zoostore.core.exception.ItemNotFoundException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.core.processor.utils.IdMismatchFinder;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EditItemOperationProcessor implements EditItemOperation {
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;
    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public EditItemResult process(EditItemInput input) {
        Item item = this.itemRepository.findById(UUID.fromString(input.getId())).orElseThrow(() -> new ItemNotFoundException(UUID.fromString(input.getId())));

        if (input.getTitle() != null) {
            item.setTitle(input.getTitle());
        }

        if (input.getDescription() != null) {
            item.setDescription(input.getDescription());
        }

        if (input.getVendorId() != null) {
            Vendor vendor = this.vendorRepository
                    .findById(UUID.fromString(input.getVendorId()))
                    .orElseThrow(() -> new VendorNotFoundException(UUID.fromString(input.getVendorId())));

            item.setVendor(vendor);
        }

        if (input.getMultimedia() != null) {

            Set<UUID> multimediaUuids = input.getMultimedia().stream().map(UUID::fromString).collect(Collectors.toSet());
            Set<Multimedia> multimedia = this.multimediaRepository.findAllByIdIn(multimediaUuids);

            if (multimedia.size() != input.getMultimedia().size()) {
                throw new MultimediaNotFoundException(IdMismatchFinder.find(multimedia, multimediaUuids));
            }

            item.setMultimedia(multimedia);
        }

        if (input.getTags() != null) {
            Set<UUID> tagUuids = input.getTags().stream().map(UUID::fromString).collect(Collectors.toSet());

            Set<Tag> tags = this.tagRepository.findAllByIdIn(tagUuids);

            if (tags.size() != input.getTags().size()) {
                throw new TagNotFoundException(IdMismatchFinder.find(tags, tagUuids));
            }

            item.setTags(tags);
        }

        if (input.getIsArchived() != null) {
            item.setIsArchived(input.getIsArchived());
        }

        Item persisted = this.itemRepository.save(item);

        return EditItemResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .isArchived(persisted.getIsArchived())
                .build();
    }
}
