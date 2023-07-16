package com.tinqin.zoostore.service.multimedia.getMultimedia;

import com.tinqin.zoostore.data.entity.Multimedia;
import com.tinqin.zoostore.data.request.multimedia.GetMultimediaByIdRequest;
import com.tinqin.zoostore.data.response.multimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.data.response.multimedia.GetMultimediaByIdResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetMultimediaServiceImpl implements GetMultimediaService {


    private final MultimediaRepository multimediaRepository;

    @Override
    public GetMultimediaByIdResponse getMultimediaById(String multimediaId) throws IdNotFoundException {

        Optional<Multimedia> multimedia = this.multimediaRepository.findById(UUID.fromString(multimediaId));

        if (multimedia.isEmpty()) {
            throw new IdNotFoundException();
        }

        return GetMultimediaByIdResponse.builder()
                .id(multimedia.get().getId().toString())
                .url(multimedia.get().getUrl())
                .build();
    }

    @Override
    public GetAllMultimediaResponse getAllMultimedia() {

        return GetAllMultimediaResponse.builder()
                .multimedia(this.multimediaRepository
                        .findAll()
                        .stream()
                        .map(this::mapMultimediaToGetMultimediaByIdResponse)
                        .collect(Collectors.toSet()))
                .build();
    }


    private GetMultimediaByIdResponse mapMultimediaToGetMultimediaByIdResponse(Multimedia multimedia) {

        return GetMultimediaByIdResponse.builder()
                .id(multimedia.getId().toString())
                .url(multimedia.getUrl())
                .build();
    }

    @Override
    public Set<Multimedia> getMultimediaByIds(Set<UUID> uuids) {
        return this.multimediaRepository.findAllByIdIn(uuids);
    }
}
