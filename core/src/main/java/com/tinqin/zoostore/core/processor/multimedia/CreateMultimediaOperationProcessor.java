package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResult;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMultimediaOperationProcessor implements CreateMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public CreateMultimediaResult process(CreateMultimediaInput request){
        Multimedia persisted = this.multimediaRepository.save(Multimedia.builder().url(request.getUrl()).build());

        return CreateMultimediaResult.builder()
                .id(persisted.getId())
                .url(persisted.getUrl())
                .build();
    }
}
