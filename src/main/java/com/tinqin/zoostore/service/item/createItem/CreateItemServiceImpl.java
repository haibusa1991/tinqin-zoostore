package com.tinqin.zoostore.service.item.createItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;
import com.tinqin.zoostore.repository.ItemRepository;
import com.tinqin.zoostore.service.multimedia.MultimediaService;
import com.tinqin.zoostore.service.tag.TagService;
import com.tinqin.zoostore.service.vendor.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateItemServiceImpl implements CreateItemService {
    private final VendorService vendorService;
    private final MultimediaService multimediaService;
    private final TagService tagService;
    private final ItemRepository itemRepository;

    @Override
    public CreateNewItemResponse createNewItem(CreateNewItemRequest request) {
        Vendor vendor = this.vendorService.getVendorById(UUID.fromString(request.getVendorId()));
        Set<Multimedia> multimedia = this.multimediaService
                .getAllMultimediaById(Arrays.stream(request.getMultimedia())
                .map(UUID::fromString)
                .toList());


        Set<Tag> tags = this.tagService.getAllTagsById(Arrays.stream(request.getTags())
                .map(UUID::fromString)
                .toList());


        Item persisted = this.itemRepository.save(Item.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .vendorId(vendor)
                .multimediaLinks(new ArrayList<>(multimedia))
                .tags(tags)
                .build());

        return CreateNewItemResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendorId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(String[]::new))
                .build();
    }
}
