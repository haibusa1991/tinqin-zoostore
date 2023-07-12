package com.tinqin.zoostore.service.multimedia.editMultimedia;

import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.data.response.multimedia.EditMultimediaResponse;
import com.tinqin.zoostore.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditMultimediaServiceImpl implements EditMultimediaService {
    private final MultimediaRepository multimediaRepository;

    @Override
    public EditMultimediaResponse editMultimedia(EditMultimediaRequest request) {
        Multimedia multimedia = this.multimediaRepository.getReferenceById(UUID.fromString(request.getId()));

        multimedia.setUrl(request.getUrl());

        Multimedia persisted = this.multimediaRepository.save(multimedia);

        return EditMultimediaResponse.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
