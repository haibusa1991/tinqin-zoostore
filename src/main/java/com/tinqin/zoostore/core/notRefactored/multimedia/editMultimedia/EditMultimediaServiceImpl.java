package com.tinqin.zoostore.core.notRefactored.multimedia.editMultimedia;

import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.api.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.api.response.multimedia.EditMultimediaResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditMultimediaServiceImpl implements EditMultimediaService {
    private final MultimediaRepository multimediaRepository;

    @Override
    public EditMultimediaResponse editMultimedia(EditMultimediaRequest request, String multimediaId) throws IdNotFoundException {
        Optional<Multimedia> multimediaOptional = this.multimediaRepository.findById(UUID.fromString(multimediaId));

        if (multimediaOptional.isEmpty()) {
            throw new IdNotFoundException();
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
