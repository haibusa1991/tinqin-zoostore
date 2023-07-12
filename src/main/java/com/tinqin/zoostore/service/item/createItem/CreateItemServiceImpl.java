package com.tinqin.zoostore.service.item.createItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;
import com.tinqin.zoostore.repository.ItemRepository;
import com.tinqin.zoostore.service.multimedia.getMultimedia.GetMultimediaService;
import com.tinqin.zoostore.service.tag.getTag.GetTagService;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateItemServiceImpl implements CreateItemService {

    private final GetVendorService getVendorService;
    private final GetMultimediaService getMultimediaService;
    private final GetTagService getTagService;
    private final ItemRepository itemRepository;

    @Override
    public CreateNewItemResponse createNewItem(CreateNewItemRequest request) {

//        TODO add checks
        Vendor vendor = this.getVendorService.getVendorById(UUID.fromString(request.getVendorId())).get();

        Set<Multimedia> multimedia = this.getMultimediaService
                .getMultimediaByIds(Arrays.stream(request.getMultimedia()).map(UUID::fromString).collect(Collectors.toSet()));


        Set<Tag> tags = this.getTagService
                .getTagsById(Arrays.stream(request.getTags()).map(UUID::fromString).collect(Collectors.toSet()));



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
