package com.tinqin.zoostore.service.multimedia;

import com.tinqin.zoostore.data.entity.Multimedia;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MultimediaService {
    Multimedia getMultimediaById(UUID multimediaId);

    Set<Multimedia> getAllMultimediaById(List<UUID> uuidList);
}
