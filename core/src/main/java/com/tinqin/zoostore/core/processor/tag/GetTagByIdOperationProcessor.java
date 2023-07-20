package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdOperation;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdInput;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetTagByIdOperationProcessor implements GetTagByIdOperation {
    private final TagRepository tagRepository;

    @Override
    public GetTagByIdResult process(GetTagByIdInput request) {

        Optional<Tag> tagOptional = this.tagRepository.findById(UuidValidator.getUuid(request.getId()));

        if (tagOptional.isEmpty()) {
            throw new TagNotFoundException(request.getId());
        }

        Tag tag = tagOptional.get();

        return GetTagByIdResult.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
