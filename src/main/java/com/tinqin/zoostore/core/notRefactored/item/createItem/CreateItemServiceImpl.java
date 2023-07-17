//package com.tinqin.zoostore.core.processor.item.createItem;
//
//import com.tinqin.zoostore.core.processor.multimedia.getMultimedia.GetMultimediaService;
//import com.tinqin.zoostore.core.processor.tag.getTag.GetTagService;
//import com.tinqin.zoostore.api.operations.getVendorById.GetVendorByIdOperation;
//import com.tinqin.zoostore.persistence.entity.Item;
//import com.tinqin.zoostore.persistence.entity.Multimedia;
//import com.tinqin.zoostore.persistence.entity.Tag;
//import com.tinqin.zoostore.persistence.entity.Vendor;
//import com.tinqin.zoostore.api.request.item.CreateNewItemRequest;
//import com.tinqin.zoostore.api.response.item.CreateNewItemResponse;
//import com.tinqin.zoostore.core.exception.VendorNotFoundException;
//import com.tinqin.zoostore.persistence.repository.ItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CreateItemServiceImpl implements CreateItemService {
//
//    private final GetVendorByIdOperation getVendorService;
//    private final GetMultimediaService getMultimediaService;
//    private final GetTagService getTagService;
//    private final ItemRepository itemRepository;
//
//    @Override
//    public CreateNewItemResponse process(CreateNewItemRequest request) throws VendorNotFoundException {
//
//        Optional<Vendor> vendor = this.getVendorService.getVendorById(UUID.fromString(request.getVendorId()));
//
//        if (vendor.isEmpty()) {
//            throw new VendorNotFoundException(request.getVendorId());
//        }
//
//
//        Set<Multimedia> multimedia = this.getMultimediaService
//                .getMultimediaByIds(Arrays.stream(request.getMultimedia()).map(UUID::fromString).collect(Collectors.toSet()));
//
//
//        Set<Tag> tags = this.getTagService
//                .getTagsById(Arrays.stream(request.getTags()).map(UUID::fromString).collect(Collectors.toSet()));
//
//
////TODO Add validation
//        Item persisted = this.itemRepository.save(Item.builder()
//                .title(request.getTitle())
//                .description(request.getDescription())
//                .vendor(vendor.get())
//                .multimediaLinks(new ArrayList<>(multimedia))
//                .tags(tags)
//                .build());
//
//        return CreateNewItemResponse.builder()
//                .id(persisted.getId().toString())
//                .title(persisted.getTitle())
//                .description(persisted.getDescription())
//                .vendorId(persisted.getVendor().toString())
//                .multimedia(persisted.getMultimediaLinks().stream().map(Multimedia::getId).map(UUID::toString).toArray(String[]::new))
//                .tags(persisted.getTags().stream().map(Tag::getId).map(UUID::toString).toArray(String[]::new))
//                .build();
//    }
//}
