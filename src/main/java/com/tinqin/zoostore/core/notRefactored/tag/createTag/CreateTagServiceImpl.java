package com.tinqin.zoostore.core.notRefactored.tag.createTag;

import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.api.request.tag.CreateTagRequest;
import com.tinqin.zoostore.api.response.tag.CreateTagResponse;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagServiceImpl implements CreateTagService {

    private final TagRepository tagRepository;

    @Override
    public CreateTagResponse createTag(CreateTagRequest request) {
        Tag persisted = this.tagRepository.save(Tag.builder().name(request.getName()).build());

        return CreateTagResponse.builder()
                .id(persisted.getId().toString())
                .name(persisted.getName())
                .build();
    }
}
