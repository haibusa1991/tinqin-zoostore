package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleInput;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleOperation;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleResult;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleSingleItem;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemByPartialTitleOperationProcessor implements GetItemByPartialTitleOperation {
    private final ItemRepository itemRepository;

    @Override
    public GetItemByPartialTitleResult process(GetItemByPartialTitleInput input) {

        PageRequest pageRequest = PageRequest.of(input.getPage() - 1, input.getItemCount(), Sort.by("title").ascending());
        List<Item> items = this.itemRepository.findAllByPartialTitle(input.getTitle(), pageRequest).getContent();

        return GetItemByPartialTitleResult.builder()
                .items(items.stream()
                        .map(this::mapToGetItemByPartialTitleSingleItem)
                        .collect(Collectors.toSet()))
                .build();
    }

    private GetItemByPartialTitleSingleItem mapToGetItemByPartialTitleSingleItem(Item item) {
        return GetItemByPartialTitleSingleItem.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getId())
                .multimedia(item.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(item.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .isArchived(item.getIsArchived())
                .build();
    }
}
