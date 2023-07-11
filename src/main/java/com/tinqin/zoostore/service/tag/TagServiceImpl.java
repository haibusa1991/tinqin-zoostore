package com.tinqin.zoostore.service.tag;

import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void initTags() {
        if (this.tagRepository.count() > 0) {
            return;
        }
        List<Tag> tags = List.of(Tag.builder().name("cat food").build(),
                Tag.builder().name("treat").build());

        this.tagRepository.saveAll(tags);
    }

    @Override
    public Tag getTagByName(String tagName) {
        return this.tagRepository.findTagByName(tagName);
    }

    @Override
    public Set<Tag> getAllTagsById(List<UUID> uuidList) {
        return uuidList.stream()
                .map(this.tagRepository::getReferenceById)
                .filter(Objects::isNull)
                .collect(Collectors.toSet());
    }
}
