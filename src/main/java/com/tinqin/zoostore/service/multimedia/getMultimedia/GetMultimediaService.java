package com.tinqin.zoostore.service.multimedia.getMultimedia;

import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.request.multimedia.GetMultimediaByIdRequest;
import com.tinqin.zoostore.data.response.multimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.data.response.multimedia.GetMultimediaByIdResponse;

import java.util.Set;
import java.util.UUID;

public interface GetMultimediaService {
    GetMultimediaByIdResponse getMultimediaById(GetMultimediaByIdRequest request);

    GetAllMultimediaResponse getAllMultimedia();

    Set<Multimedia> getMultimediaByIds(Set<UUID> uuids);
}