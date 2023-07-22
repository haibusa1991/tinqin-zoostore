package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.editTag.EditTagOperation;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagInput;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditTagOperationProcessor implements EditTagOperation {
    private final TagRepository tagRepository;

    @Override
    public EditTagResult process(EditTagInput input) {
        Tag tag = this.tagRepository.findById(input.getId()).orElseThrow(()->new TagNotFoundException(input.getId()));

        tag.setName(input.getName());

        Tag persisted = this.tagRepository.save(tag);

        return EditTagResult.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    }
}
