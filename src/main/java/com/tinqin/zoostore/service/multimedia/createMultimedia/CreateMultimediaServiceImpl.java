package com.tinqin.zoostore.service.multimedia.createMultimedia;

import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.request.multimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.data.response.multimedia.CreateMultimediaResponse;
import com.tinqin.zoostore.repository.MultimediaRepository;
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
