package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperation;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemInput;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperationProcessorSingleItem;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResult;
import com.tinqin.zoostore.core.exception.PageableParameterException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllItemOperationProcessor implements GetAllItemOperation {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public GetAllItemsResult process(GetAllItemInput input) {

        UUID tagId = input.getTagId();
        PageRequest pageRequest = PageRequest.of(input.getPage() - 1, input.getItemCount(), Sort.by("title").ascending());

        if (tagId != null) {
            return this.getItemsByTag(input, pageRequest);
        }

        return this.getAllItems(input, pageRequest);
    }

    private GetAllItemOperationProcessorSingleItem mapItemToGetAllItemOperationProcessorSingleItem(Item item) {

        return GetAllItemOperationProcessorSingleItem.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getId())
                .multimedia(item.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(item.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .isArchived(item.getIsArchived())
                .build();
    }

    private GetAllItemsResult getItemsByTag(GetAllItemInput input, PageRequest pageRequest) {
        Page<Item> items;
        Tag tag = tagRepository.findById(input.getTagId()).orElseThrow(() -> new TagNotFoundException(input.getTagId()));

        try {
            items = input.getShouldIncludeArchived()
                    ? this.itemRepository.findAllByTagsContaining(tag, pageRequest)
                    : this.itemRepository.findAllByIsArchivedEqualsAndTagsContaining(false, tag, pageRequest);

        } catch (IllegalArgumentException e) {
            throw new PageableParameterException(e.getMessage());
        }

        return GetAllItemsResult.builder()
                .items(items.getContent()
                        .stream()
                        .map(this::mapItemToGetAllItemOperationProcessorSingleItem)
                        .collect(Collectors.toSet()))
                .build();

    }

    private GetAllItemsResult getAllItems(GetAllItemInput input, PageRequest pageRequest) {
        Page<Item> items;

        try {
            items = input.getShouldIncludeArchived()
                    ? this.itemRepository.findAll(pageRequest)
                    : this.itemRepository.findAllByIsArchivedEquals(false, pageRequest);

        } catch (IllegalArgumentException e) {
            throw new PageableParameterException(e.getMessage());
        }

        return GetAllItemsResult.builder()
                .items(items.getContent()
                        .stream()
                        .map(this::mapItemToGetAllItemOperationProcessorSingleItem)
                        .collect(Collectors.toSet()))
                .build();
    }
}
