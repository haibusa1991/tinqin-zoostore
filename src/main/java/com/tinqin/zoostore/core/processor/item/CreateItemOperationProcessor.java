package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemRequest;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
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

import java.util.*;

@Service
@RequiredArgsConstructor
public class CreateItemOperationProcessor implements CreateItemOperation {
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;
    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public CreateItemResponse process(CreateItemRequest request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        Optional<Vendor> vendorOptional = this.vendorRepository.findById(UuidValidator.getUuid(request.getVendorId()));

        if (vendorOptional.isEmpty()) {
            throw new VendorNotFoundException(request.getVendorId());
        }

        Vendor vendor = vendorOptional.get();

        Set<UUID> multimediaUuids = this.parseUuid(request.getMultimedia());
        for (UUID multimediaUuid : multimediaUuids) {
            if(!this.multimediaRepository.existsById(multimediaUuid)){
                throw new MultimediaNotFoundException(multimediaUuid.toString());
            }
        }
        Set<Multimedia> multimedia = this.multimediaRepository.findAllByIdIn(multimediaUuids);

        Set<UUID> tagUuids = this.parseUuid(request.getTags());
        for (UUID tagUuid : tagUuids) {
            if(!this.tagRepository.existsById(tagUuid)){
                throw new TagNotFoundException(tagUuid.toString());
            }
        }
        Set<Tag> tags = this.tagRepository.findAllByIdIn(tagUuids);

        Item persisted = this.itemRepository.save(Item.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .vendor(vendor)
                .multimedia(multimedia)
                .tags(tags)
                .build());

        return CreateItemResponse.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }


    private Set<UUID> parseUuid(String[] uuids) throws InvalidUuidException {
        Set<UUID> uuidSet = new HashSet<>();
        for (String uuid : uuids) {
            uuidSet.add(UuidValidator.getUuid(uuid));
        }
        return uuidSet;
    }
}
