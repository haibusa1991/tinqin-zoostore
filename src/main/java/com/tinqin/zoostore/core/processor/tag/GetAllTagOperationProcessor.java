package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagOperation;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagRequest;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
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
    public GetAllTagResponse process(GetAllTagRequest request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        List<GetAllTagOperationProcessorSingleItem> allTags = this.tagRepository
                .findAll()
                .stream()
                .map(this::mapTagToGetAllTagOperationProcessorSingleItem)
                .toList();

        return GetAllTagResponse.builder()
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
