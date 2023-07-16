package com.tinqin.zoostore.service.item.editItem;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.data.request.item.*;
import com.tinqin.zoostore.data.response.item.*;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import com.tinqin.zoostore.repository.ItemRepository;
import com.tinqin.zoostore.service.multimedia.getMultimedia.GetMultimediaService;
import com.tinqin.zoostore.service.tag.getTag.GetTagService;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EditItemServiceImpl implements EditItemService {

    private final ItemRepository itemRepository;
    private final GetVendorService getVendorService;
    private final GetMultimediaService getMultimediaService;
    private final GetTagService getTagService;

    @Override
    public EditItemTitleResponse editItemTitle(EditItemTitleRequest request, String itemId) throws IdNotFoundException {
        Item item = this.getItemById(itemId);
        item.setTitle(request.getTitle());

        Item persisted = this.itemRepository.save(item);

        return EditItemTitleResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(String[]::new))
                .build();
    }


    @Override
    public EditItemDescriptionResponse editItemDescription(EditItemDescriptionRequest request, String itemId) throws IdNotFoundException {
        Item item = this.getItemById(itemId);

        item.setTitle(request.getDescription());

        Item persisted = this.itemRepository.save(item);

        return EditItemDescriptionResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(String[]::new))
                .build();
    }

    @Override
    public EditItemVendorResponse editItemVendor(EditItemVendorRequest request, String itemId) throws IdNotFoundException, VendorNotFoundException {
        Item item = this.getItemById(itemId);

        Optional<Vendor> vendorById = this.getVendorService.getVendorById(UUID.fromString(request.getVendorId()));

        if (vendorById.isEmpty()) {
            throw new VendorNotFoundException();
        }

        item.setVendor(vendorById.get());

        Item persisted = this.itemRepository.save(item);

        return EditItemVendorResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).map(UUID::toString).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).map(UUID::toString).toArray(String[]::new))
                .build();
    }

    @Override
    public EditItemMultimediaResponse editItemMultimedia(EditItemMultimediaRequest request, String itemId) throws IdNotFoundException {
        Set<Multimedia> multimedia = this.getMultimediaService.getMultimediaByIds(Arrays.stream(request.getMultimediaIds()).map(UUID::fromString).collect(Collectors.toSet()));

        Item item = this.getItemById(itemId);
        item.setMultimediaLinks(multimedia.stream().toList());
        Item persisted = this.itemRepository.save(item);

        return EditItemMultimediaResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).map(UUID::toString).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).map(UUID::toString).toArray(String[]::new))
                .build();
    }

    @Override
    public EditItemTagsResponse editItemTags(EditItemTagsRequest request, String itemId) throws IdNotFoundException {
        Set<Tag> tags = this.getTagService.getTagsById(Arrays.stream(request.getTagIds()).map(UUID::fromString).collect(Collectors.toSet()));


        Item item = this.getItemById(itemId);
        item.setTags(tags);
        Item persisted = this.itemRepository.save(item);

        return EditItemTagsResponse.builder()
                .id(persisted.getId().toString())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId().toString())
                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).map(UUID::toString).toArray(String[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).map(UUID::toString).toArray(String[]::new))
                .build();
    }

    @Override
    public void updateArchivedStatus(Boolean isArchived, String itemId) throws IdNotFoundException {
        Item item = this.getItemById(itemId);
        item.setIsArchived(isArchived);
        this.itemRepository.save(item);
    }

    private Item getItemById(String itemId) throws IdNotFoundException {
        Optional<Item> item = this.itemRepository.findById(UUID.fromString(itemId));

        if (item.isEmpty()) {
            throw new IdNotFoundException();
        }

        return item.get();
    }
}
