package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResponse;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditMultimediaOperationProcessor implements EditMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public EditMultimediaResponse process(EditMultimediaRequest request) throws InvalidUuidException, VendorNotFoundException {
        Optional<Multimedia> multimediaOptional = this.multimediaRepository.findById(UuidValidator.getUuid(request.getId()));

        if (multimediaOptional.isEmpty()) {
            throw new VendorNotFoundException(request.getId());
        }

        Multimedia multimedia = multimediaOptional.get();
        multimedia.setUrl(request.getUrl());

        Multimedia persisted = this.multimediaRepository.save(multimedia);

        return EditMultimediaResponse.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
