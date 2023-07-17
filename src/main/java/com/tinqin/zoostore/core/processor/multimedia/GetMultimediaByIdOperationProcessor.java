package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdRequest;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetMultimediaByIdOperationProcessor implements GetMultimediaByIdOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public GetMultimediaByIdResponse process(GetMultimediaByIdRequest request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException {
        Optional<Multimedia> multimediaOptional = this.multimediaRepository.findById(UuidValidator.getUuid(request.getId()));

        if (multimediaOptional.isEmpty()) {
            throw new MultimediaNotFoundException(request.getId());
        }

        Multimedia multimedia = multimediaOptional.get();

        return GetMultimediaByIdResponse.builder()
                .id(multimedia.getId())
                .url(multimedia.getUrl())
                .build();
    }
}
