package com.tinqin.zoostore.service.tag.editTag;


import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.request.tag.EditTagRequest;
import com.tinqin.zoostore.data.response.tag.EditTagResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class EditTagServiceImpl implements EditTagService {

    private final TagRepository tagRepository;

    @Override
    public EditTagResponse editTag(EditTagRequest request, String itemId) throws IdNotFoundException {
        Optional<Tag> tagOptional = this.tagRepository.findById(UUID.fromString(itemId));

        if(tagOptional.isEmpty()){
            throw new IdNotFoundException();
        }

        Tag tag = tagOptional.get();

        tag.setName(request.getName());

        Tag persisted = this.tagRepository.save(tag);

        return EditTagResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
