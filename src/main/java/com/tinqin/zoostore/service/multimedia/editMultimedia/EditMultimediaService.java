package com.tinqin.zoostore.service.multimedia.editMultimedia;

import com.tinqin.zoostore.data.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.data.response.multimedia.EditMultimediaResponse;

public interface EditMultimediaService {
    EditMultimediaResponse editMultimedia(EditMultimediaRequest request);
}
