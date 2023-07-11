package com.tinqin.zoostore.services.tag;

import com.tinqin.zoostore.models.Tag;

public interface TagService {
    void initTags();

    Tag getTagByName(String tagName);
}
