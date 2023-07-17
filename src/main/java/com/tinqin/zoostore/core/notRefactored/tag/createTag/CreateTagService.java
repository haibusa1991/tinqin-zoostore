package com.tinqin.zoostore.core.notRefactored.tag.createTag;

import com.tinqin.zoostore.api.request.tag.CreateTagRequest;
import com.tinqin.zoostore.api.response.tag.CreateTagResponse;

public interface CreateTagService {
    CreateTagResponse createTag(CreateTagRequest request);
}
