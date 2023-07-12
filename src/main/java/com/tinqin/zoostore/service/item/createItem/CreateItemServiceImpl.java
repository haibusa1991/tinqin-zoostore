package com.tinqin.zoostore.service.item.createItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.EditItemTitleResponse;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import com.tinqin.zoostore.repository.ItemRepository;
import com.tinqin.zoostore.service.multimedia.getMultimedia.GetMultimediaService;
import com.tinqin.zoostore.service.tag.getTag.GetTagService;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateItemServiceImpl implements CreateItemService {

    private final GetVendorService getVendorService;
    private final GetMultimediaService getMultimediaService;
    private final GetTagService getTagService;
    private final ItemRepository itemRepository;

    @Override
    public EditItemTitleResponse createNewItem(CreateNewItemRequest request) throws VendorNotFoundException {

        Optional<Vendor> vendor = this.getVendorService.getVendorById(UUID.fromString(request.getVendorId()));

        if (vendor.isEmpty()) {
            throw new VendorNotFoundException();
        }


        Set<Multimedia> multimedia = this.getMultimediaService
                .getMultimediaByIds(Arrays.stream(request.getMultimedia()).map(UUID::fromString).collect(Collectors.toSet()));


        Set<Tag> tags = this.getTagService
                .getTagsById(Arrays.stream(request.getTags()).map(UUID::fromString).collect(Collectors.toSet()));


//TODO Add validation
        Item persisted = this.itemRepository.save(Item.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .vendor(vendor.get())
                .multimediaLinks(new ArrayList<>(multimedia))
                .tags(tags)
                .build());

        return EditItemTitleResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).map(UUID::toString).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).map(UUID::toString).toArray(String[]::new))
                .build();
    }
}
