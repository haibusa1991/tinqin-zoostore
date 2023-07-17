package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdOperation;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdRequest;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetTagByIdOperationProcessor implements GetTagByIdOperation {
    private final TagRepository tagRepository;

    @Override
    public GetTagByIdResponse process(GetTagByIdRequest request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {

        Optional<Tag> tagOptional = this.tagRepository.findById(UuidValidator.getUuid(request.getId()));

        if(tagOptional.isEmpty()){
            throw new TagNotFoundException(request.getId());
        }

        Tag tag = tagOptional.get();

        return GetTagByIdResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
