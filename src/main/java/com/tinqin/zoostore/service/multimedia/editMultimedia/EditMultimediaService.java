package com.tinqin.zoostore.service.multimedia.editMultimedia;

import com.tinqin.zoostore.data.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.data.response.multimedia.EditMultimediaResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;

public interface EditMultimediaService {
    EditMultimediaResponse editMultimedia(EditMultimediaRequest request, String multimediaId) throws IdNotFoundException;
}
