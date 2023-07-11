package com.tinqin.zoostore.services.item;

import com.tinqin.zoostore.models.Item;
import com.tinqin.zoostore.models.Tag;
import com.tinqin.zoostore.models.Vendor;
import com.tinqin.zoostore.repositories.ItemRepository;
import com.tinqin.zoostore.requests.item.CreateNewItemRequest;
import com.tinqin.zoostore.responses.item.CreateNewItemResponse;
import com.tinqin.zoostore.responses.item.GetAllItemsResponse;
import com.tinqin.zoostore.responses.item.GetItemByIdResponse;
import com.tinqin.zoostore.services.tag.TagService;
import com.tinqin.zoostore.services.vendor.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final VendorService vendorService;
    private final ItemRepository itemRepository;
    private final TagService tagService;

    public ItemServiceImpl(VendorService vendorService, ItemRepository itemRepository, TagService tagService) {
        this.vendorService = vendorService;
        this.itemRepository = itemRepository;
        this.tagService = tagService;
    }

    @Override
    public CreateNewItemResponse createNewItem(CreateNewItemRequest request) {
        return new CreateNewItemResponse().builder().build();
    }

    @Override
    public List<GetAllItemsResponse> getAllItems() {
        return this.itemRepository.findAll().stream().map(this::mapToGetAllItemsResponse).toList();
    }

    @Override
    public void initItems() {
        if (this.itemRepository.count() > 0) {
            return;
        }

        Vendor whiskas = this.vendorService.getVendorByName("Whiskas");
        Tag catFood = this.tagService.getTagByName("cat food");
        Tag treat = this.tagService.getTagByName("treat");

        List<Item> items = List.of(Item.builder()
                        .title("Anti-Hairball")
                        .description("Reduces the risk of hairball forming.")
                        .vendor(whiskas)
                        .tags(Set.of(catFood))
                        .build(),
                Item.builder()
                        .title("Crunchy pockets")
                        .description("Crunchy treat with soft filling.")
                        .vendor(whiskas)
                        .tags(Set.of(catFood, treat))
                        .build()
        );

        this.itemRepository.saveAll(items);


    }

    @Override
    public GetItemByIdResponse getItemById(String itemId) {
        Item item = this.itemRepository.getItemById(UUID.fromString(itemId));

        return item == null ? null : mapToGetItemByIdResponse(item);
    }

    private GetAllItemsResponse mapToGetAllItemsResponse(Item item) {

        return GetAllItemsResponse.builder()
                .id(item.getId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getId().toString())
                .multimedia(item.getMultimediaLinks().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .tags(item.getTags().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .build();
    }

    private GetItemByIdResponse mapToGetItemByIdResponse(Item item) {

        return GetItemByIdResponse.builder()
                .id(item.getId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getId().toString())
                .multimedia(item.getMultimediaLinks().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .tags(item.getTags().stream().map(e -> e.getId().toString()).toArray(String[]::new))
                .build();
    }
}
