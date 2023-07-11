package com.tinqin.zoostore.service.multimedia;

import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.repository.MultimediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    private final MultimediaRepository multimediaRepository;

    public MultimediaServiceImpl(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public Multimedia getMultimediaById(UUID multimediaId) {
        return this.multimediaRepository.getReferenceById(multimediaId);
    }

    @Override
    public Set<Multimedia> getAllMultimediaById(List<UUID> uuidList) {

        return uuidList.stream()
                .map(this.multimediaRepository::getReferenceById)
                .filter(Objects::isNull)
                .collect(Collectors.toSet());
    }
}
