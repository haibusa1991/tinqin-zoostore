package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
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
    public EditMultimediaResult process(EditMultimediaInput input)  {
        Multimedia multimedia = this.multimediaRepository.findById(input.getId()).orElseThrow(() -> new MultimediaNotFoundException(input.getId()));
        multimedia.setUrl(input.getUrl());

        Multimedia persisted = this.multimediaRepository.save(multimedia);

        return EditMultimediaResult.builder()
                .id(persisted.getId().toString())
                .url(persisted.getUrl())
                .build();
    }
}
