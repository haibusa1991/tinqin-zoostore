package com.tinqin.zoostore.service.tag.createTag;

import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.request.tag.CreateTagRequest;
import com.tinqin.zoostore.data.response.tag.CreateTagResponse;
import com.tinqin.zoostore.repository.TagRepository;
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
