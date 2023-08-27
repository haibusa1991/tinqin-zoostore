package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemInput;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResult;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.core.processor.utils.IdMismatchFinder;
import com.tinqin.zoostore.persistence.entity.*;
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
    public CreateItemResult process(CreateItemInput input) {
        System.out.println(input);
        Vendor vendor = this.vendorRepository
                .findById(input.getVendorId())
                .orElseThrow(() -> new VendorNotFoundException(input.getVendorId()));


        Set<Multimedia> multimedia = this.multimediaRepository.findAllByIdIn(input.getMultimedia());
        if (multimedia.size() != input.getMultimedia().size()) {
            throw new MultimediaNotFoundException(IdMismatchFinder.find(multimedia, input.getMultimedia()));
        }


        Set<Tag> tags = this.tagRepository.findAllByIdIn(input.getTags());
        if (tags.size() != input.getTags().size()) {
            throw new TagNotFoundException(IdMismatchFinder.find(tags, input.getTags()));
        }

        Item persisted = this.itemRepository.save(Item.builder()
                .title(input.getTitle())
                .description(input.getDescription())
                .vendor(vendor)
                .multimedia(multimedia)
                .tags(tags)
                .build());


        return CreateItemResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
