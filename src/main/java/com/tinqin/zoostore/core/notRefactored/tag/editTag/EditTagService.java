package com.tinqin.zoostore.core.notRefactored.tag.editTag;

import com.tinqin.zoostore.api.request.tag.EditTagRequest;
import com.tinqin.zoostore.api.response.tag.EditTagResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;

public interface EditTagService {
    EditTagResponse editTag(EditTagRequest request, String itemId) throws IdNotFoundException;
}
