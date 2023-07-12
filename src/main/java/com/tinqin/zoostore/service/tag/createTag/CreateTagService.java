package com.tinqin.zoostore.service.tag.createTag;

import com.tinqin.zoostore.data.request.tag.CreateTagRequest;
import com.tinqin.zoostore.data.response.tag.CreateTagResponse;

public interface CreateTagService {
    CreateTagResponse createTag(CreateTagRequest request);
}
