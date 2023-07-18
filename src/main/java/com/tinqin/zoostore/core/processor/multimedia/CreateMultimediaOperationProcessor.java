package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMultimediaOperationProcessor implements CreateMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public CreateMultimediaResponse process(CreateMultimediaRequest request){
        Multimedia persisted = this.multimediaRepository.save(Multimedia.builder().url(request.getUrl()).build());

        return CreateMultimediaResponse.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
