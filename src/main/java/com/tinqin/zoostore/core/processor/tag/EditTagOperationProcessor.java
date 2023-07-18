package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.editTag.EditTagOperation;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagRequest;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditTagOperationProcessor implements EditTagOperation {
    private final TagRepository tagRepository;

    @Override
    public EditTagResponse process(EditTagRequest request) {
        Optional<Tag> tagOptional = this.tagRepository.findById(UuidValidator.getUuid(request.getId()));

        if (tagOptional.isEmpty()) {
            throw new TagNotFoundException(request.getId());
        }

        Tag tag = tagOptional.get();

        tag.setName(request.getName());

        Tag persisted = this.tagRepository.save(tag);

        return EditTagResponse.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    }
}
