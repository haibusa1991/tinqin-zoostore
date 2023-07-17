package com.tinqin.zoostore.core.notRefactored.tag.getTag;

import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.api.response.tag.GetAllTagResponse;
import com.tinqin.zoostore.api.response.tag.GetTagByIdResponse;

import java.util.Set;
import java.util.UUID;

public interface GetTagService {



    GetTagByIdResponse getTagById(String tagId);

    GetAllTagResponse getAll();

    Set<Tag> getTagsById(Set<UUID> uuids);
}
