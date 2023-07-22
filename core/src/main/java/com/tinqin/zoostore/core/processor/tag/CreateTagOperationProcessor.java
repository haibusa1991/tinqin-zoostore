package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagOperation;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagInput;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagResult;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTagOperationProcessor implements CreateTagOperation {
    private final TagRepository tagRepository;

    @Override
    public CreateTagResult process(CreateTagInput input) {
        Tag persisted = this.tagRepository.save(Tag.builder().name(input.getName()).build());

        return CreateTagResult.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    }
}
