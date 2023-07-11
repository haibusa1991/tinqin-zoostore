package com.tinqin.zoostore.service.tag;

import com.tinqin.zoostore.data.entity.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {
    void initTags();

    Tag getTagByName(String tagName);

    Set<Tag> getAllTagsById(List<UUID> uuidList);
}
