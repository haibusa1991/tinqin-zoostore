package com.tinqin.zoostore.service.tag.getTag;

import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.response.tag.GetAllTagResponse;
import com.tinqin.zoostore.data.response.tag.GetTagByIdResponse;

import java.util.Set;
import java.util.UUID;

public interface GetTagService {



    GetTagByIdResponse getTagById(String tagId);

    GetAllTagResponse getAll();

    Set<Tag> getTagsById(Set<UUID> uuids);
}
