package com.tinqin.zoostore.service.multimedia.createMultimedia;

import com.tinqin.zoostore.data.request.multimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.data.response.multimedia.CreateMultimediaResponse;

public interface CreateMultimediaService {
    CreateMultimediaResponse createMultimedia(CreateMultimediaRequest request);
}
