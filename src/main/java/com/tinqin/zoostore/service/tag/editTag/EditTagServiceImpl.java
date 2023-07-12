package com.tinqin.zoostore.service.tag.editTag;


import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.request.tag.EditTagRequest;
import com.tinqin.zoostore.data.response.tag.EditTagResponse;
import com.tinqin.zoostore.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class EditTagServiceImpl implements EditTagService {

    private final TagRepository tagRepository;

    @Override
    public EditTagResponse editTag(EditTagRequest request) {
        Tag tag = this.tagRepository.getReferenceById(UUID.fromString(request.getId()));

        tag.setName(request.getName());

        Tag persisted = this.tagRepository.save(tag);

        return EditTagResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
