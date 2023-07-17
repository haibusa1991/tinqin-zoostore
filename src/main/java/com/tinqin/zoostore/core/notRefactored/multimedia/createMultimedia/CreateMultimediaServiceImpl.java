package com.tinqin.zoostore.core.notRefactored.multimedia.createMultimedia;

import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.api.request.multimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.api.response.multimedia.CreateMultimediaResponse;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMultimediaServiceImpl implements CreateMultimediaService {

    private final MultimediaRepository multimediaRepository;

    @Override
    public CreateMultimediaResponse createMultimedia(CreateMultimediaRequest request) {
        Multimedia persisted = this.multimediaRepository.save(Multimedia.builder().url(request.getUrl()).build());

        return CreateMultimediaResponse.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
