package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetAllMultimediaOperationProcessor implements GetAllMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public GetAllMultimediaResponse process(GetAllMultimediaRequest request) {

            return GetAllMultimediaResponse.builder()
                    .multimedia(this.multimediaRepository
                            .findAll()
                            .stream()
                            .map(this::mapMultimediaToGetAllMultimediaOperationProcessorSingleItem)
                            .toList())
                    .build();
        }


    private GetAllMultimediaOperationProcessorSingleItem mapMultimediaToGetAllMultimediaOperationProcessorSingleItem(Multimedia multimedia) {

        return GetAllMultimediaOperationProcessorSingleItem.builder()
                .id(multimedia.getId())
                .url(multimedia.getUrl())
                .build();
    }
}
