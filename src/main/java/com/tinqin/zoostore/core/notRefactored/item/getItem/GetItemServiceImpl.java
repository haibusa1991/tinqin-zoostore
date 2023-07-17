//package com.tinqin.zoostore.core.notRefactored.item.getItem;
//
//import com.tinqin.zoostore.persistence.entity.Item;
//import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResponse;
//import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResponse;
//import com.tinqin.zoostore.core.exception.IdNotFoundException;
//import com.tinqin.zoostore.persistence.repository.ItemRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class GetItemServiceImpl implements GetItemService {
//    private final ItemRepository itemRepository;
//
//    public GetItemServiceImpl(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    @Override
//    public GetAllItemsResponse getAllItemsResponse(Boolean includeArchived) {
//        if (includeArchived) {
//            return GetAllItemsResponse.builder()
//                    .items(this.itemRepository.findAll()
//                            .stream()
//                            .map(this::mapItemToGetItemByIdResponse)
//                            .collect(Collectors.toSet()))
//                    .build();
//        }
//
//        return GetAllItemsResponse.builder()
//                .items(this.itemRepository
//                        .findAllByIsArchivedFalse()
//                        .stream()
//                        .map(this::mapItemToGetItemByIdResponse)
//                        .collect(Collectors.toSet()))
//                .build();
//    }
//
//    @Override
//    public GetItemByIdResponse getItemById(String itemId) throws IdNotFoundException {
//
//        UUID id;
//        try {
//            id = UUID.fromString(itemId);
//        } catch (IllegalArgumentException e) {
//            throw new IdNotFoundException();
//        }
//
//
//        Optional<Item> item = this.itemRepository.findById(id);
//
//        if (item.isEmpty()) {
//            throw new IdNotFoundException();
//        }
//
//        return this.mapItemToGetItemByIdResponse(item.get());
//    }
//
//    private GetItemByIdResponse mapItemToGetItemByIdResponse(Item item) {
//
//        return GetItemByIdResponse.builder()
//                .id(item.getId().toString())
//                .title(item.getTitle())
//                .description(item.getDescription())
//                .vendorId(item.getVendor().getId().toString())
//                .multimedia(item.getMultimediaLinks().stream().map(e -> e.getId().toString()).toArray(String[]::new))
//                .tags(item.getTags().stream().map(e -> e.getId().toString()).toArray(String[]::new))
//                .isArchived(item.getIsArchived())
//                .build();
//    }
//}
