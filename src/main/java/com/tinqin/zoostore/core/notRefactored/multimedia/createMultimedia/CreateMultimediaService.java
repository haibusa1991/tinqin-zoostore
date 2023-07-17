package com.tinqin.zoostore.core.notRefactored.multimedia.createMultimedia;

import com.tinqin.zoostore.api.request.multimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.api.response.multimedia.CreateMultimediaResponse;

public interface CreateMultimediaService {
    CreateMultimediaResponse createMultimedia(CreateMultimediaRequest request);
}
