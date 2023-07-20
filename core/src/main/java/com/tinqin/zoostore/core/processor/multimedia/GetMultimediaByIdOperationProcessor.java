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
    public GetMultimediaByIdResult process(GetMultimediaByIdInput request) {
        Optional<Multimedia> multimediaOptional = this.multimediaRepository.findById(UuidValidator.getUuid(request.getId()));

        if (multimediaOptional.isEmpty()) {
            throw new MultimediaNotFoundException(request.getId());
        }

        Multimedia multimedia = multimediaOptional.get();

        return GetMultimediaByIdResult.builder()
                .id(multimedia.getId())
                .url(multimedia.getUrl())
                .build();
    }
}
