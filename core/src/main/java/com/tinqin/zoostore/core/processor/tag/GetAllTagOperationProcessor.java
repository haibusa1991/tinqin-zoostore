package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagOperation;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagInput;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagOperationProcessorSingleItem;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResult;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllTagOperationProcessor implements GetAllTagOperation {
    private final TagRepository tagRepository;

    @Override
    public GetAllTagResult process(GetAllTagInput request) {
        List<GetAllTagOperationProcessorSingleItem> allTags = this.tagRepository
                .findAll()
                .stream()
                .map(this::mapTagToGetAllTagOperationProcessorSingleItem)
                .toList();

        return GetAllTagResult.builder()
                .tags(allTags)
                .build();
    }

    private GetAllTagOperationProcessorSingleItem mapTagToGetAllTagOperationProcessorSingleItem(Tag tag) {
        return GetAllTagOperationProcessorSingleItem.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
