package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditMultimediaOperationProcessor implements EditMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public EditMultimediaResult process(EditMultimediaInput request)  {
        Optional<Multimedia> multimediaOptional = this.multimediaRepository.findById(UuidValidator.getUuid(request.getId()));

        if (multimediaOptional.isEmpty()) {
            throw new VendorNotFoundException(request.getId());
        }

        Multimedia multimedia = multimediaOptional.get();
        multimedia.setUrl(request.getUrl());

        Multimedia persisted = this.multimediaRepository.save(multimedia);

        return EditMultimediaResult.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
