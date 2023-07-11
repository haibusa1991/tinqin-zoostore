package com.tinqin.zoostore.services.tag;

import com.tinqin.zoostore.models.Tag;
import com.tinqin.zoostore.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
