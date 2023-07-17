package com.tinqin.zoostore.core.notRefactored.multimedia.getMultimedia;

import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.api.response.multimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.api.response.multimedia.GetMultimediaByIdResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;

import java.util.Set;
import java.util.UUID;

public interface GetMultimediaService {
    GetMultimediaByIdResponse getMultimediaById(String multimediaId) throws IdNotFoundException;

    GetAllMultimediaResponse getAllMultimedia();

    Set<Multimedia> getMultimediaByIds(Set<UUID> uuids);
}
