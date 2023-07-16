package com.tinqin.zoostore.service.tag.editTag;

import com.tinqin.zoostore.data.request.tag.EditTagRequest;
import com.tinqin.zoostore.data.response.tag.EditTagResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;

public interface EditTagService {
    EditTagResponse editTag(EditTagRequest request, String itemId) throws IdNotFoundException;
}
