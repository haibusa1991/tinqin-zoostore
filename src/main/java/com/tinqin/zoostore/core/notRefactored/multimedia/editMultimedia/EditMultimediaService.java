package com.tinqin.zoostore.core.notRefactored.multimedia.editMultimedia;

import com.tinqin.zoostore.api.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.api.response.multimedia.EditMultimediaResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;

public interface EditMultimediaService {
    EditMultimediaResponse editMultimedia(EditMultimediaRequest request, String multimediaId) throws IdNotFoundException;
}
