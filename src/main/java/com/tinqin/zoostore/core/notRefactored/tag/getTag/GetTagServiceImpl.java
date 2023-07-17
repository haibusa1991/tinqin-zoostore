package com.tinqin.zoostore.core.notRefactored.tag.getTag;

import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.api.response.tag.GetAllTagResponse;
import com.tinqin.zoostore.api.response.tag.GetTagByIdResponse;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTagServiceImpl implements GetTagService {

    private final TagRepository tagRepository;

    @Override
    public GetTagByIdResponse getTagById(String tagId) {

        Tag tag = this.tagRepository.findById(UUID.fromString(tagId)).get();

        return GetTagByIdResponse.builder()
                .id(tag.getId().toString())
                .name(tag.getName())
                .build();
    }

    @Override
    public GetAllTagResponse getAll() {
        List<GetTagByIdResponse> allTags = this.tagRepository
                .findAll()
                .stream()
                .map(this::mapTagToGetTagByIdResponse)
                .toList();

        return GetAllTagResponse.builder()
                .tags(allTags)
                .build();
    }

    private GetTagByIdResponse mapTagToGetTagByIdResponse(Tag tag) {
        return GetTagByIdResponse.builder()
                .id(tag.getId().toString())
                .name(tag.getName())
                .build();
    }

    @Override
    public Set<Tag> getTagsById(Set<UUID> uuids) {
        return this.tagRepository.findAllByIdIn(uuids);
    }
}
