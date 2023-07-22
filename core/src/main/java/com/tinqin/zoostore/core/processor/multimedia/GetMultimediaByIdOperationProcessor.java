package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetMultimediaByIdOperationProcessor implements GetMultimediaByIdOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public GetMultimediaByIdResult process(GetMultimediaByIdInput input) {
        Multimedia multimedia = this.multimediaRepository.findById(input.getId()).orElseThrow(()->new MultimediaNotFoundException(input.getId()));

        return GetMultimediaByIdResult.builder()
                .id(multimedia.getId())
                .url(multimedia.getUrl())
                .build();
    }
}
